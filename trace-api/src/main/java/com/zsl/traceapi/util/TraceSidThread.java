package com.zsl.traceapi.util;

import com.zsl.traceapi.config.kafka.producer.TraceCodeProducerKafka;
import com.zsl.traceapi.dao.ZslTraceSidDao;
import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TracePreSidInsertParam;
import com.zsl.tracedb.mapper.ZslTraceMapper;
import com.zsl.tracedb.mapper.ZslTraceSidMapper;
import com.zsl.tracedb.model.ZslTraceSid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TraceSidThread
 * @Description 预生成sid线程类
 * @Author binggleW
 * @Date 2019-10-08 16:20
 * @Version 1.0
 **/
public  class TraceSidThread extends Thread{
    private static Logger logger = LoggerFactory.getLogger(TraceSidThread.class);

    private ZslTraceSubcodeDao zslTraceSubcodeDao= (ZslTraceSubcodeDao)SpringContextUtil.getBean(ZslTraceSubcodeDao.class);

    private ZslTraceSidMapper zslTraceSidMapper= (ZslTraceSidMapper)SpringContextUtil.getBean(ZslTraceSidMapper.class);

    private Long zslTradeSid;

    public TraceSidThread(Long zslTradeSid){
        this.zslTradeSid = zslTradeSid;
    }

    @Override
    public void run(){
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
