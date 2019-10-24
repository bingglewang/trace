package com.zsl.traceapi.util;

import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TraceOutCodeUpdateParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UpdateOutCodeIdThread
 * @Description 批量改成外码线程类
 * @Author binggleW
 * @Date 2019-10-23 16:21
 * @Version 1.0
 **/
public class UpdateOutCodeIdThread  extends Thread{
    private static Logger logger = LoggerFactory.getLogger(UpdateOutCodeIdThread.class);

    private ZslTraceSubcodeDao zslTraceSubcodeDao = (ZslTraceSubcodeDao) SpringContextUtil.getBean(ZslTraceSubcodeDao.class);

    private List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams;

    public UpdateOutCodeIdThread(List<TraceOutCodeUpdateParam> traceOutCodeUpdateParams){
        this.traceOutCodeUpdateParams = traceOutCodeUpdateParams;
    }

    @Override
    public void run() {
        try {
            int size = this.traceOutCodeUpdateParams.size();
            int groupCount = 500;
            int n = size % groupCount == 0 ? (size / groupCount) : (size / groupCount + 1);
            List<List<TraceOutCodeUpdateParam>> result = ListGroupUtil.averageAssign(this.traceOutCodeUpdateParams, n);
            for (List<TraceOutCodeUpdateParam> item : result) {
                zslTraceSubcodeDao.updateOutCodeById(item);
            }
            logger.info("批量改成外码成功"+new Date());
        }catch (Exception e){
            logger.info(e.getMessage());
        }
    }
}
