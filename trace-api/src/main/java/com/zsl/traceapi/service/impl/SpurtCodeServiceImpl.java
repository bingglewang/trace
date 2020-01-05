package com.zsl.traceapi.service.impl;

import com.zsl.traceapi.dao.ZslTraceSubcodeDao;
import com.zsl.traceapi.service.SpurtCodeService;
import com.zsl.traceapi.vo.SpurtCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SpurtCodeServiceImpl
 * @Description 喷码
 * @Author binggleW
 * @Date 2020-01-05 11:52
 * @Version 1.0
 **/
@Service
public class SpurtCodeServiceImpl implements SpurtCodeService {

    @Autowired
    private ZslTraceSubcodeDao zslTraceSubcodeDao;

    @Override
    public List<SpurtCodeVo> getSidsByTraceCodeNumber(String traceCodeNumber) {
        List<SpurtCodeVo> spurtCodeVos = zslTraceSubcodeDao.getSidsByTraceCodeNumber(traceCodeNumber);
        return spurtCodeVos;
    }

    @Override
    public boolean isExitByTraceCodeNumberAndSid(String traceCodeNumber, Long traceSid) {
        SpurtCodeVo spurtCodeVo = zslTraceSubcodeDao.getSubCodeBySidAndCode(traceCodeNumber,traceSid);
        if(spurtCodeVo != null){
            return true;
        }
        return false;
    }

}
