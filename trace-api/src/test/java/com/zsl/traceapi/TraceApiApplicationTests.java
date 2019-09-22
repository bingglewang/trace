package com.zsl.traceapi;

import com.sun.glass.ui.Application;
import com.zsl.traceapi.config.kafka.consumer.TraceCodeConsumerKafka;
import com.zsl.traceapi.config.kafka.producer.TraceCodeImageProducerKafka;
import com.zsl.traceapi.config.kafka.producer.TraceCodeProducerKafka;
import com.zsl.traceapi.dao.ZslTraceSidDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TracePreSidInsertParam;
import com.zsl.traceapi.util.RandomUtil;
import com.zsl.tracedb.mapper.ZslTraceSidMapper;
import com.zsl.tracedb.model.ZslTraceSid;
import com.zsl.tracedb.model.ZslTraceSubcode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TraceApiApplication.class)
public class TraceApiApplicationTests {

    private static Logger logger = LoggerFactory.getLogger(TraceApiApplicationTests.class);

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Autowired
    private ZslTraceSidMapper zslTraceSidMapper;


    @Test
    public void contextLoads() {
        Long zslTradeSid = 1L;
        logger.info("要预生成的id:{}", zslTradeSid);
        //根据id 获取sid记录
        ZslTraceSid zslTraceSid = zslTraceSidMapper.selectByPrimaryKey(zslTradeSid);
        if(zslTraceSid != null){
            Long startIndex = zslTraceSid.getSidStartIndex();
            Long endIndex = zslTraceSid.getSidEndIndex();
            List<TracePreSidInsertParam> insertParams = new ArrayList<>();
            Long currentTimeStamp = System.currentTimeMillis() * 1000;
            for(Long i = startIndex; i <= endIndex; i++){
                TracePreSidInsertParam tracePreSidInsertParam = new TracePreSidInsertParam();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(RandomUtil.getRandNumberCode(4));
                stringBuffer.append(currentTimeStamp);
                stringBuffer.append(i + 1);
                tracePreSidInsertParam.setTraceSid(i);
                tracePreSidInsertParam.setTraceSubcodeNumber(stringBuffer.toString());
                insertParams.add(tracePreSidInsertParam);
                if (insertParams.size() >= 10000) {
                    zslTraceSubcodeDao.insertCodePreSidBatch(insertParams);
                    insertParams.clear();
                }
            }
            //循环完
            if (insertParams.size() > 0) {
                zslTraceSubcodeDao.insertCodePreSidBatch(insertParams);
            }
            //修改生成状态
            ZslTraceSid sidUpdate = new ZslTraceSid();
            sidUpdate.setId(zslTradeSid);
            sidUpdate.setSidPreCreate((byte)1); //修改为已经生成完
            zslTraceSidMapper.updateByPrimaryKeySelective(sidUpdate);
            logger.info("已经预生成完的id:{}", zslTradeSid);
        }
    }

}
