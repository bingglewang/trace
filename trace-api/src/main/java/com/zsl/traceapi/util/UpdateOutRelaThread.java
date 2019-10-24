package com.zsl.traceapi.util;

import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.dto.TraceOutCodeUpdateParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UpdateOutRelaThread
 * @Description 批量外码关联字码线程类
 * @Author binggleW
 * @Date 2019-10-23 16:23
 * @Version 1.0
 **/
public class UpdateOutRelaThread extends  Thread {
    private static Logger logger = LoggerFactory.getLogger(UpdateOutRelaThread.class);

    private ZslTraceSubcodeDao zslTraceSubcodeDao = (ZslTraceSubcodeDao) SpringContextUtil.getBean(ZslTraceSubcodeDao.class);

    private List<TraceOutCodeUpdateParam> traceOutCodeUpdateParamParent;

    public UpdateOutRelaThread(List<TraceOutCodeUpdateParam> traceOutCodeUpdateParamParent){
        this.traceOutCodeUpdateParamParent = traceOutCodeUpdateParamParent;
    }

    @Override
    public void run() {
        try {
            int size = this.traceOutCodeUpdateParamParent.size();
            int groupCount = 500;
            int n = size % groupCount == 0 ? (size / groupCount) : (size / groupCount + 1);
            List<List<TraceOutCodeUpdateParam>> result = ListGroupUtil.averageAssign(this.traceOutCodeUpdateParamParent, n);
            for (List<TraceOutCodeUpdateParam> item : result) {
                zslTraceSubcodeDao.updateOutCodeBatch(item);
            }
            logger.info("批量外码关联字码成功" + new Date());
        }catch (Exception e){
            logger.info(e.getMessage());
        }
    }
}
