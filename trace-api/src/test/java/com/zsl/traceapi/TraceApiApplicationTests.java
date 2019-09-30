package com.zsl.traceapi;

import com.sun.glass.ui.Application;
import com.zsl.traceapi.config.kafka.consumer.TraceCodeConsumerKafka;
import com.zsl.traceapi.config.kafka.producer.TraceCodeImageProducerKafka;
import com.zsl.traceapi.config.kafka.producer.TraceCodeProducerKafka;
import com.zsl.traceapi.dao.ZslTraceSidDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TracePreSidInsertParam;
import com.zsl.traceapi.util.HttpClientUtil;
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

    }

}
