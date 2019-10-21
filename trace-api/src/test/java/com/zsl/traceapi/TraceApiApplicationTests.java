package com.zsl.traceapi;

import com.zsl.traceapi.dao.MerchantDao;
import com.zsl.traceapi.dto.MerchantPointDto;
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

    @Test
    public void contextLoads() {
        String mobile = "15578263484";
        MerchantPointDto merchantPointUpdate = merchantDao.getOtherPointByMobile(mobile);
        System.out.println("结果："+merchantPointUpdate);
    }

}
