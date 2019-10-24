package com.zsl.traceapi;

import com.zsl.traceapi.dao.MerchantDao;
import com.zsl.traceapi.dto.MerchantPointDto;
import com.zsl.traceapi.service.TraceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TraceApiApplication.class)
public class TraceApiApplicationTests {

    private static Logger logger = LoggerFactory.getLogger(TraceApiApplicationTests.class);

    @Autowired
    private MerchantDao merchantDao;

    @Autowired
    private TraceService traceService;

    @Test
    public void contextLoads() {
        MerchantPointDto merchantPointUpdate = traceService.getCirculateNodeInfo(499);
        System.out.println("结果："+merchantPointUpdate);
    }

}
