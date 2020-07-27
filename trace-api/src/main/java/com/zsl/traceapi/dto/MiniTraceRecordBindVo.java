package com.zsl.traceapi.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName MiniTraceRecordBindVo
 * @Description TODO
 * @Author binggleW
 * @Date 2020-07-24 10:22
 * @Version 1.0
 **/
@Data
public class MiniTraceRecordBindVo {
    /**
     * 外码或内码
     */
    private List<Long> sids;

    /**
     * 关联商品id
     */
    private Integer traceGoodId;

    /**
     * 生产批次
     */
    private String productionBatch;
}
