package com.zsl.traceapi.config.rabbitmq.consumer;

import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TraceSubcodeInsertParam;
import com.zsl.traceapi.util.RandomUtil;
import com.zsl.tracedb.mapper.ZslTraceMapper;
import com.zsl.tracedb.model.ZslTrace;
import com.zsl.tracedb.model.ZslTraceExample;
import com.zsl.tracedb.model.ZslTraceSubcode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 追溯子码监听消费者
 */
@Component
@RabbitListener(queues = "trace.code.generator")
public class TraceCodeConsumer {
    private static Logger logger = LoggerFactory.getLogger(TraceCodeConsumer.class);

    private String codeUrl = "https://scode.cntracechain.com/#/Produce?SID=";

    @Autowired
    private ZslTraceMapper zslTraceMapper;

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @RabbitHandler
    public void handle(String traceCodeNumber){
        new MyThread(traceCodeNumber).start();
    }

    class MyThread extends Thread{
        private String traceCodeNumber;

        MyThread(String traceCodeNumber){
            this.traceCodeNumber = traceCodeNumber;
        }

        public void run(){
            logger.info("要生成的批次号:{}",traceCodeNumber);
            //判断是否已经有，有则删掉之前的
            ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectByCodeNumber(traceCodeNumber);
            if(zslTraceSubcode != null){
                int j = zslTraceSubcodeDao.deleteByCodeNumber(traceCodeNumber);
                logger.info(zslTraceSubcode+"的删除结果:{}",j);
            }
            //拿到追溯信息
            ZslTraceExample zslTraceExample = new ZslTraceExample();
            ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
            criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
            List<ZslTrace>  zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
            if(!(CollectionUtils.isEmpty(zslTraceList))){
                Long count = zslTraceList.get(0).getTraceApplyCount();
                List<TraceSubcodeInsertParam> insertParams = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    StringBuffer stringBuffer = new StringBuffer();
                    TraceSubcodeInsertParam subcodeInsertParam = new TraceSubcodeInsertParam();
                    stringBuffer.append(RandomUtil.getRandNumberCode(4));
                    stringBuffer.append(System.currentTimeMillis()*1000);
                    stringBuffer.append(i+1);
                    subcodeInsertParam.setTraceIndex(new Long(i+1));
                    subcodeInsertParam.setTraceCodeNumber(traceCodeNumber);
                    subcodeInsertParam.setTraceSubcodeNumber(stringBuffer.toString());
                    insertParams.add(subcodeInsertParam);
                    if(insertParams.size() >= 10000){
                        zslTraceSubcodeDao.insertCodeBatch(insertParams);
                        insertParams.clear();
                    }
                }
                if(insertParams.size() > 0){
                    zslTraceSubcodeDao.insertCodeBatch(insertParams);
                }
                //修改追溯状态为：已生成Y
                ZslTrace updateTrace = new ZslTrace();
                updateTrace.setTraceId(zslTraceList.get(0).getTraceId());
                updateTrace.setTraceBack3("Y");
                zslTraceMapper.updateByPrimaryKeySelective(updateTrace);
            }
            logger.info("已经完成的批次号:{}",traceCodeNumber);
        }
    }
}
