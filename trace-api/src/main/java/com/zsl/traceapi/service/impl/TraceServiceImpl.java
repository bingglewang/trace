package com.zsl.traceapi.service.impl;

import com.zsl.traceapi.service.TraceService;
import com.zsl.tracedb.mapper.ZslTraceMapper;
import com.zsl.tracedb.model.ZslTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraceServiceImpl implements TraceService {
    @Autowired
    private ZslTraceMapper zslTraceMapper;

    @Override
    public ZslTrace getZslTraceById(Integer id) {
        return  zslTraceMapper.selectByPrimaryKey(id);
    }

    @Override
    public ZslTrace insert(ZslTrace zslTrace) {
        int i = zslTraceMapper.insertSelective(zslTrace);
        if(i > 0){
            return zslTrace;
        }else{
            return null;
        }
    }
}
