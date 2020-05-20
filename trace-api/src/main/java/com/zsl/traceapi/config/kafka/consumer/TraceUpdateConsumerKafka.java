package com.zsl.traceapi.config.kafka.consumer;

import com.alibaba.fastjson.JSONObject;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TraceCodeRelation;
import com.zsl.traceapi.dto.TraceSubcodeUpdateParam;
import com.zsl.traceapi.dto.TraceSubcodeUpdateParamSid;
import com.zsl.traceapi.util.SpringContextUtil;
import com.zsl.tracedb.mapper.ZslTraceMapper;
import com.zsl.tracedb.model.ZslTrace;
import com.zsl.tracedb.model.ZslTraceExample;
import com.zsl.tracedb.model.ZslTracePapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TraceUpdateConsumerKafka {
    private static Logger logger = LoggerFactory.getLogger(TraceUpdateConsumerKafka.class);

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Autowired
    private ZslTraceMapper zslTraceMapper;


    @KafkaListener(topics = "traceUpdate")
    public void handle(ConsumerRecord<?, ?> record) {
        logger.info("接受到的json字符串:{}", record.value());
        String traceCodeJson = record.value().toString();
        //原来
        //new CoreThread(traceCodeJson).start();
        //现在
        run(traceCodeJson);
    }


    /**
     * 判断是纸质还是电子
     *
     * @param traceCodeNumber
     * @return
     */
    private boolean isPapperOrElectric(String traceCodeNumber) {
        ZslTraceExample zslTraceExample = new ZslTraceExample();
        ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
        criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
        List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
        if (CollectionUtils.isNotEmpty(zslTraceList) && zslTraceList.get(0).getTraceApplyType() - 1 == 0) {
            return true;
        }
        return false;
    }

    public void run(String traceCodeJson) {
        try {
            TraceCodeRelation traceCodeRelation = JSONObject.parseObject(traceCodeJson, TraceCodeRelation.class);
            Long fromNumber = traceCodeRelation.getFromNumber();
            Long toNumber = traceCodeRelation.getToNumber();
            int goodsId = traceCodeRelation.getGoodsId();
            int stallId = traceCodeRelation.getStallId();
            String traceCodeNumber = traceCodeRelation.getTraceCodeNumber();

            //判断是纸质还是电子
            boolean isPaperType = isPapperOrElectric(traceCodeNumber);
            Long count = toNumber - fromNumber + 1;
            if (isPaperType) {
                List<ZslTracePapper> papperList = traceCodeRelation.getTracePappers();
                if(papperList != null){
                    long countTemp = fromNumber;
                    for(int i = 0;i < papperList.size();i++){
                        long start = papperList.get(i).getTraceNumStart();
                        long end = papperList.get(i).getTraceNumEnd();
                        //关联操作
                        List<Long> traceCodeIdsPaper = zslTraceSubcodeDao.selectBySidRange(start, end);
                        List<TraceSubcodeUpdateParamSid> updateSidParams = new ArrayList<>();
                        for (int j = 0; j < traceCodeIdsPaper.size(); j++) {
                            TraceSubcodeUpdateParamSid traceSubcodeUpdateParamSid = new TraceSubcodeUpdateParamSid(countTemp, traceCodeNumber, goodsId, stallId, traceCodeIdsPaper.get(j));
                            updateSidParams.add(traceSubcodeUpdateParamSid);
                            if(updateSidParams.size() % 1000 == 0){
                                int m = zslTraceSubcodeDao.updateGoodsAndStallSid(updateSidParams);
                                updateSidParams.clear();
                            }
                            countTemp++;
                        }
                        if (updateSidParams.size() > 0) {
                            zslTraceSubcodeDao.updateGoodsAndStallSid(updateSidParams);
                        }
                    }
                }
            } else {
                //电子
                int totalPage = (int) Math.ceil((double) count / 1000);
                for (int currentPage = 1; currentPage <= totalPage; currentPage++) {
                    Long fromIndex = 0L;
                    Long toIndex = 0L;
                    fromIndex = new Long((currentPage - 1) * 1000 + fromNumber);
                    if (currentPage - totalPage == 0) {
                        toIndex = toNumber;
                    } else {
                        toIndex = new Long(currentPage * 1000) + fromNumber;
                    }

                    List<Long> traceCodeIds = zslTraceSubcodeDao.selectByRange(fromIndex, toIndex, traceCodeNumber);
                    List<TraceSubcodeUpdateParam> updateParams = new ArrayList<>();
                    for (int i = 0; i < traceCodeIds.size(); i++) {
                        TraceSubcodeUpdateParam traceSubcodeUpdateParam = new TraceSubcodeUpdateParam(goodsId, stallId, traceCodeIds.get(i));
                        updateParams.add(traceSubcodeUpdateParam);
                    }
                    int j = zslTraceSubcodeDao.updateGoodsAndStall(updateParams);
                }
            }
        } catch (Exception e) {
        }
    }
}
