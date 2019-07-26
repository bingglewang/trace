package com.zsl.traceapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zsl.traceapi.config.rabbitmq.producer.TraceUpdateProducer;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TraceCodeRelation;
import com.zsl.traceapi.dto.TraceSubcodeUpdateParam;
import com.zsl.traceapi.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TraceApiApplicationTests {
    @Autowired
    private RedisService redisService;

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Autowired
    private TraceUpdateProducer traceUpdateProducer;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        try {
            TraceCodeRelation traceCodeRelation = new TraceCodeRelation();
            traceCodeRelation.setFromNumber(1001L);
            traceCodeRelation.setToNumber(4444L);
            traceCodeRelation.setGoodsId(123);
            traceCodeRelation.setStallId(123);
            traceCodeRelation.setTraceCodeNumber("zs1563958663716000574946324");
            String sendJsonStr = JSONObject.toJSONString(traceCodeRelation);
            traceUpdateProducer.sendMessage(sendJsonStr,100);
        }catch (Exception e){

        }
      /*  Long start = System.currentTimeMillis();
        Long fromNumber = 1001L;
        Long toNumber = 4444L;
        int goodsId = 6;
        int stallId = 6;
        String traceCodeNumber = "zs1563958663716000574946324";
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
            System.out.println("开始："+fromIndex+"，结束："+toIndex);
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
        Long end = System.currentTimeMillis();
        System.out.println("cast : " + (end - start) / 1000 + "s");*/
      /*  String s = "{\n" +
                "        \"id\": 56,\n" +
                "        \"token\": \"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoie1wiaGVhZHF1YXJ0ZXJzXCI6MCxcInJvbGVOYW1lXCI6XCJST0xFX0hFQURRVUFSVEVSU19PUEVSQVRFXCIsXCJpZFwiOjN9IiwiaXNzIjoiNTYiLCJleHAiOjE1NjIwNTY5MzIsImlhdCI6MTU2MjA0OTczMn0.S6IUhrYWADx25mJM6UPdgOpUFddnAMoNQBQh4gmeo14\",\n" +
                "        \"accountName\": \"tuobi\",\n" +
                "        \"realName\": \"tuobi\",\n" +
                "        \"mobile\": \"tuobi\",\n" +
                "        \"enabled\": true,\n" +
                "        \"accountType\": 0,\n" +
                "        \"role\": {\n" +
                "            \"id\": 3,\n" +
                "            \"roleName\": \"ROLE_HEADQUARTERS_OPERATE\",\n" +
                "            \"headquarters\": 0\n" +
                "        },\n" +
                "        \"status\": 1,\n" +
                "        \"picUrl\": \"https://zs-1256645015.cos.ap-guangzhou.myqcloud.com/trace/2019/7/2/a8168012-6dc0-43b0-b6c8-c96c4a06c585.png\",\n" +
                "        \"createTime\": \"2019-07-03 03:41:13\"\n" +
                "    }";
        redisService.set("message13751857556",s);*/
       /* String token = (String) redisService.get("message13751857556");
        String tokenTmp = StringEscapeUtils.unescapeEcmaScript(token);
        String targetStr =  MStringUtils.trimFirstAndLastChar(tokenTmp,'"');
        JSONObject jsonObject = JSONObject.parseObject(targetStr);
        System.out.println("有没有："+token);
        System.out.println("哈哈哈："+jsonObject);*/

      /* String s = "hellofde4554";
       s = s.substring(s.indexOf("hello"));
       String tem = s.replace("hello","world");
       System.out.println("替换后的值："+tem);*/

        //生成追溯子码
      /*  Long count = 1000000L;
        String traceCode = "zs123456";
        Long start = System.currentTimeMillis();
        List<TraceSubcodeInsertParam> insertParams = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            TraceSubcodeInsertParam subcodeInsertParam = new TraceSubcodeInsertParam();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(RandomUtil.getRandNumberCode(4));
            stringBuffer.append(System.currentTimeMillis() * 1000);
            stringBuffer.append(i + 1);
            subcodeInsertParam.setTraceIndex(new Long(i + 1));
            subcodeInsertParam.setTraceCodeNumber(traceCode);
            subcodeInsertParam.setTraceSubcodeNumber(stringBuffer.toString());
            insertParams.add(subcodeInsertParam);
            if(insertParams.size() >= 100000){
                zslTraceSubcodeDao.insertCodeBatch(insertParams);
                insertParams = new ArrayList<>();
            }
        }
        if(insertParams.size() > 0){
            zslTraceSubcodeDao.insertCodeBatch(insertParams);
        }
        Long end = System.currentTimeMillis();
        System.out.println("sql执行时间：" + (end - start) / 1000 + "秒");*/

        // 获取配置的数据源
       /* DataSource dataSource = applicationContext.getBean(DataSource.class);
        String traceCode = "zs123456";

            // 开时时间
            Long begin = new Date().getTime();

            // sql前缀
            String prefix = "INSERT INTO zsl_trace_subcode (trace_index, trace_code_number, trace_sub_code_number) VALUES(?,?,?) ";
            try {
                Connection conn = dataSource.getConnection();
                // 保存sql后缀
                StringBuffer suffix = new StringBuffer();
                // 设置事务为非自动提交
                conn.setAutoCommit(false);
                PreparedStatement pst = conn.prepareStatement(prefix);
                // 外层循环，总提交事务次数
                for (int i = 1; i <= 100; i++) {
                    // 第次提交步长
                    for (int j = 1; j <= 10000; j++) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(RandomUtil.getRandNumberCode(4));
                        stringBuffer.append(System.currentTimeMillis()*1000);
                        stringBuffer.append(i * j);
                       *//* // 构建sql后缀
                        suffix.append("(" + j * i + ", "+traceCode +", " +
                                stringBuffer.toString() + "),");*//*
                        pst.setLong(1,j * i);
                        pst.setString(2,traceCode);
                        pst.setString(3,stringBuffer.toString());
                        pst.addBatch(prefix);
                    }
                    // 构建完整sql
                    //String sql = prefix + suffix.substring(0, suffix.length() - 1);
                    // 添加执行sql

                    // 执行操作
                    pst.executeBatch();
                    // 提交事务
                    conn.commit();
                    // 清空上一次添加的数据
                    suffix = new StringBuffer();
                }
                // 头等连接
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // 结束时间
            Long end = new Date().getTime();
            // 耗时
            System.out.println("cast : " + (end - begin) / 1000 + " ms");*/
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
