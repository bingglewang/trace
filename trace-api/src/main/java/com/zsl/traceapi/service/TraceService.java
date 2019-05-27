package com.zsl.traceapi.service;

import com.zsl.tracedb.model.ZslTrace;
import org.springframework.transaction.annotation.Transactional;

public interface TraceService {
    /**
     * 根据id获取追溯
     * @param id
     * @return
     */
    ZslTrace getZslTraceById(Integer id);

    /**
     * 新增追溯
     * @param zslTrace
     * @return
     */
    @Transactional
    ZslTrace insert(ZslTrace zslTrace);
}
