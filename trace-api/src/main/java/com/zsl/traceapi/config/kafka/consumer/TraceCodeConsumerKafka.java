package com.zsl.traceapi.config.kafka.consumer;

import com.zsl.traceapi.config.rabbitmq.producer.TraceCodeProducer;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TraceSubcodeInsertParam;
import com.zsl.traceapi.util.RandomUtil;
import com.zsl.tracedb.mapper.ZslTraceMapper;
import com.zsl.tracedb.model.ZslTrace;
import com.zsl.tracedb.model.ZslTraceExample;
import com.zsl.tracedb.model.ZslTraceSubcode;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 追溯子码监听消费者
 */
@Component
public class TraceCodeConsumerKafka {
    private static Logger logger = LoggerFactory.getLogger(TraceCodeConsumerKafka.class);

    @Autowired
    private ZslTraceMapper zslTraceMapper;

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Autowired
    private TraceCodeProducer traceCodeProducer;

    @KafkaListener(topics = "test")
    public void handle(ConsumerRecord<?, ?> record){
        String traceCodeNumber = record.value().toString();
        new MyThread(traceCodeNumber).start();
    }

    class MyThread extends Thread{
        private String traceCodeNumber;

        MyThread(String traceCodeNumber){
            this.traceCodeNumber = traceCodeNumber;
        }

        public void run(){
            try {
                logger.info("要生成的批次号:{}", traceCodeNumber);
                //判断是否已经有，有则删掉之前的
                ZslTraceSubcode zslTraceSubcode = zslTraceSubcodeDao.selectByCodeNumber(traceCodeNumber);
                if (zslTraceSubcode != null) {
                    int j = zslTraceSubcodeDao.deleteByCodeNumber(traceCodeNumber);
                    logger.info(zslTraceSubcode + "的删除结果:{}", j);
                }
                //拿到追溯信息
                ZslTraceExample zslTraceExample = new ZslTraceExample();
                ZslTraceExample.Criteria criteria = zslTraceExample.createCriteria();
                criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
                List<ZslTrace> zslTraceList = zslTraceMapper.selectByExample(zslTraceExample);
                if (!(CollectionUtils.isEmpty(zslTraceList))) {
                    Long count = zslTraceList.get(0).getTraceApplyCount();
                    List<TraceSubcodeInsertParam> insertParams = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        StringBuffer stringBuffer = new StringBuffer();
                        TraceSubcodeInsertParam subcodeInsertParam = new TraceSubcodeInsertParam();
                        stringBuffer.append(RandomUtil.getRandNumberCode(4));
                        stringBuffer.append(System.currentTimeMillis() * 1000);
                        stringBuffer.append(i + 1);
                        subcodeInsertParam.setTraceIndex(new Long(i + 1));
                        subcodeInsertParam.setTraceCodeNumber(traceCodeNumber);
                        subcodeInsertParam.setTraceSubcodeNumber(stringBuffer.toString());
                        insertParams.add(subcodeInsertParam);
                        if (insertParams.size() >= 10000) {
                            zslTraceSubcodeDao.insertCodeBatch(insertParams);
                            insertParams.clear();
                        }
                    }
                    if (insertParams.size() > 0) {
                        zslTraceSubcodeDao.insertCodeBatch(insertParams);
                    }
                    //修改追溯状态为：已生成Y
                    ZslTrace updateTrace = new ZslTrace();
                    updateTrace.setTraceId(zslTraceList.get(0).getTraceId());
                    updateTrace.setTraceBack3("Y");
                    zslTraceMapper.updateByPrimaryKeySelective(updateTrace);
                }
                logger.info("已经完成的批次号:{}", traceCodeNumber);
            }catch (Exception e){
                logger.info("处理失败:{}", traceCodeNumber);
                try {
                    traceCodeProducer.sendMessage(traceCodeNumber, 100);
                }catch (Exception e1){
                }
            }
        }
    }
}
