package com.zsl.traceapi.config.rabbitmq.consumer;

import com.alibaba.fastjson.JSONObject;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TraceCodeRelation;
import com.zsl.traceapi.dto.TraceSubcodeUpdateParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RabbitListener(queues = "trace.code.update")
public class TraceUpdateConsumer {
    private static Logger logger = LoggerFactory.getLogger(TraceUpdateConsumer.class);

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;


    @RabbitHandler
    public void handle(String traceCodeJson){
        logger.info("接受到的json字符串:{}", traceCodeJson);
        try {
            TraceCodeRelation traceCodeRelation = JSONObject.parseObject(traceCodeJson, TraceCodeRelation.class);
            Long fromNumber = traceCodeRelation.getFromNumber();
            Long toNumber = traceCodeRelation.getToNumber();
            int goodsId = traceCodeRelation.getGoodsId();
            int stallId = traceCodeRelation.getStallId();
            String traceCodeNumber = traceCodeRelation.getTraceCodeNumber();
            Long count = toNumber - fromNumber + 1;
            int totalPage = (int)Math.ceil((double)count/1000);
            for(int currentPage = 1; currentPage <= totalPage; currentPage++){
                Long fromIndex = 0L;
                Long toIndex = 0L;
                fromIndex = new Long((currentPage - 1)*1000 + fromNumber);
                if(currentPage - totalPage == 0){
                    toIndex = toNumber;
                }else{
                    toIndex = new Long(currentPage*1000)+fromNumber;
                }
                List<Long> traceCodeIds = zslTraceSubcodeDao.selectByRange(fromIndex,toIndex,traceCodeNumber);
                List<TraceSubcodeUpdateParam> updateParams = new ArrayList<>();
                for(int i = 0;i < traceCodeIds.size();i++ ){
                    TraceSubcodeUpdateParam traceSubcodeUpdateParam = new TraceSubcodeUpdateParam();
                    traceSubcodeUpdateParam.setGoodsId(goodsId);
                    traceSubcodeUpdateParam.setStallId(stallId);
                    traceSubcodeUpdateParam.setId(traceCodeIds.get(i));
                    updateParams.add(traceSubcodeUpdateParam);
                }
                new MyThread(updateParams).start();
            }
        }catch (Exception e){

        }
    }

    class MyThread extends Thread {
        List<TraceSubcodeUpdateParam> updateParams;
        MyThread(List<TraceSubcodeUpdateParam> updateParams){
            this.updateParams = updateParams;
        }
        public void run (){
            int j = zslTraceSubcodeDao.updateGoodsAndStall(updateParams);
        }

    }
}
