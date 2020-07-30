package com.zsl.traceapi.service;

import com.zsl.traceapi.dto.ConflictCodeDetailParam;
import com.zsl.traceapi.dto.ConflictCodeParam;
import com.zsl.traceapi.dto.PageParams;

/**
 * @ClassName ConflictCodeService
 * @Description 串货
 * @Author binggleW
 * @Date 2020-07-30 11:01
 * @Version 1.0
 **/
public interface ConflictCodeService {

    /**
     * 串货列表
     * @return
     */
    Object getConflictCodeByPage(PageParams pageParams, ConflictCodeParam queryParam);

    /**
     * 串货明细
     * @return
     */
    Object getConflictCodeDetailByPage(PageParams pageParams, ConflictCodeDetailParam queryParam,Integer conflictCodeId);
}
