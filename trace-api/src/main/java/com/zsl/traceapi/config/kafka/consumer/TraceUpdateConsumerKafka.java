package com.zsl.traceapi.config.kafka.consumer;

import com.alibaba.fastjson.JSONObject;
import com.zsl.traceapi.dao.ZslTraceSidDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TraceCodeRelation;
import com.zsl.traceapi.dto.TraceSubcodeUpdateParam;
import com.zsl.traceapi.dto.TraceSubcodeUpdateParamSid;
import com.zsl.tracedb.mapper.ZslTraceMapper;
import com.zsl.tracedb.mapper.ZslTraceSidMapper;
import com.zsl.tracedb.model.ZslTrace;
import com.zsl.tracedb.model.ZslTraceExample;
import com.zsl.tracedb.model.ZslTraceSid;
import org.apache.commons.collections.CollectionUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.zsl.traceapi.dto.InitPaperStart.INIT_SID_START_INDES;

@Component
public class TraceUpdateConsumerKafka {
    private static Logger logger = LoggerFactory.getLogger(TraceUpdateConsumerKafka.class);

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Autowired
    private ZslTraceMapper zslTraceMapper;

    @Autowired
    private ZslTraceSidDao zslTraceSidDao;

    @Autowired
    private ZslTraceSidMapper zslTraceSidMapper;


    @KafkaListener(topics = "traceUpdate")
    public void handle(ConsumerRecord<?, ?> record){
        logger.info("接受到的json字符串:{}", record.value());
        String traceCodeJson = record.value().toString();
        new CoreThread(traceCodeJson).start();
    }

    class CoreThread extends  Thread {
        String traceCodeJson;
        CoreThread(String traceCodeJson){
            this.traceCodeJson = traceCodeJson;
        }
        @Override
        public void run() {
            try {
                TraceCodeRelation traceCodeRelation = JSONObject.parseObject(traceCodeJson, TraceCodeRelation.class);
                Long fromNumber = traceCodeRelation.getFromNumber();
                Long toNumber = traceCodeRelation.getToNumber();
                int goodsId = traceCodeRelation.getGoodsId();
                int stallId = traceCodeRelation.getStallId();
                String traceCodeNumber = traceCodeRelation.getTraceCodeNumber();

                //判断是纸质还是电子
                ZslTraceExample zslTraceExample = new ZslTraceExample();
                ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
                criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
                List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
                boolean isPaperType = false;
                if(CollectionUtils.isNotEmpty(zslTraceList) && zslTraceList.get(0).getTraceApplyType() - 1 == 0){
                    isPaperType = true;
                }

                Long count = toNumber - fromNumber + 1;
                int totalPage = (int)Math.ceil((double)count/1000);
                Long start = 0L;
                Long end = 0L;
                ZslTraceSid zslTraceSid = zslTraceSidDao.selectNewPrePaperCode();

                if(zslTraceSid.getSidStartIndex() - zslTraceSid.getSidCurrentIndex() == 0){
                    start = zslTraceSid.getSidCurrentIndex();
                    end = zslTraceSid.getSidCurrentIndex() + count -1;
                }else{
                    start = zslTraceSid.getSidCurrentIndex() + 1;
                    end = zslTraceSid.getSidCurrentIndex() + count;
                }

                if(isPaperType) {
                    //更改当前纸质指针位置
                    if (zslTraceSid != null) {
                        ZslTraceSid updateE = new ZslTraceSid();
                        updateE.setId(zslTraceSid.getId());
                        updateE.setSidCurrentIndex(end);
                        zslTraceSidMapper.updateByPrimaryKeySelective(updateE);
                    }
                }
                for(int currentPage = 1; currentPage <= totalPage; currentPage++){
                    Long fromIndex = 0L;
                    Long toIndex = 0L;
                    fromIndex = new Long((currentPage - 1)*1000 + fromNumber);
                    if(currentPage - totalPage == 0){
                        toIndex = toNumber;
                    }else{
                        toIndex = new Long(currentPage*1000)+fromNumber;
                    }
                    // 区分纸质和电子
                    List<Long> traceCodeIds = null;
                    if(isPaperType){

                        if(zslTraceSid == null){
                            return ;
                        }

                        if(end > zslTraceSid.getSidEndIndex()){
                            logger.info("预生成的纸质码不足:{}", zslTraceSid.getId());
                            return;
                        }
                        traceCodeIds = zslTraceSubcodeDao.selectBySidRange(start,end);

                        List<TraceSubcodeUpdateParamSid> updateSidParams = new ArrayList<>();
                        Long countTemp = fromNumber;
                        for(int i = 0;i < traceCodeIds.size();i++ ){
                            TraceSubcodeUpdateParamSid traceSubcodeUpdateParamSid = new TraceSubcodeUpdateParamSid();
                            traceSubcodeUpdateParamSid.setTraceIndex(countTemp);
                            traceSubcodeUpdateParamSid.setTraceCodeNumber(zslTraceList.get(0).getTraceCodeNumber());
                            traceSubcodeUpdateParamSid.setGoodsId(goodsId);
                            traceSubcodeUpdateParamSid.setStallId(stallId);
                            traceSubcodeUpdateParamSid.setId(traceCodeIds.get(i));
                            updateSidParams.add(traceSubcodeUpdateParamSid);
                            countTemp++;
                        }
                        logger.info("纸质线程："+updateSidParams);
                        int j = zslTraceSubcodeDao.updateGoodsAndStallSid(updateSidParams);
                        logger.info("纸质线程：结果"+j);
                        //new MyThreadSid(updateSidParams).start();
                    }else{
                        traceCodeIds = zslTraceSubcodeDao.selectByRange(fromIndex,toIndex,traceCodeNumber);

                        List<TraceSubcodeUpdateParam> updateParams = new ArrayList<>();
                        for(int i = 0;i < traceCodeIds.size();i++ ){
                            TraceSubcodeUpdateParam traceSubcodeUpdateParam = new TraceSubcodeUpdateParam();
                            traceSubcodeUpdateParam.setGoodsId(goodsId);
                            traceSubcodeUpdateParam.setStallId(stallId);
                            traceSubcodeUpdateParam.setId(traceCodeIds.get(i));
                            updateParams.add(traceSubcodeUpdateParam);
                        }
                        int j = zslTraceSubcodeDao.updateGoodsAndStall(updateParams);
                        //new MyThread(updateParams).start();
                    }
                }
            }catch (Exception e){

            }
        }
    }


    class MyThreadSid extends Thread {
        List<TraceSubcodeUpdateParamSid> updateParams;
        MyThreadSid(List<TraceSubcodeUpdateParamSid> updateParams){
            this.updateParams = updateParams;
        }

        @Override
        public void run (){
            logger.info("纸质线程："+updateParams);
            int j = zslTraceSubcodeDao.updateGoodsAndStallSid(updateParams);
            logger.info("纸质线程：结果"+j);
        }

    }

    class MyThread extends Thread {
        List<TraceSubcodeUpdateParam> updateParams;
        MyThread(List<TraceSubcodeUpdateParam> updateParams){
            this.updateParams = updateParams;
        }

        @Override
        public void run (){
            int j = zslTraceSubcodeDao.updateGoodsAndStall(updateParams);
        }

    }
}
