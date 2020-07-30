package com.zsl.traceapi.dto;

import lombok.Data;

/**
 * @ClassName ConflictCodeParam
 * @Description 串货列表 查询参数封装
 * @Author binggleW
 * @Date 2020-07-30 11:06
 * @Version 1.0
 **/
@Data
public class ConflictCodeParam {
    /** 追溯SID */
    private Long Sid;
    /** 追溯批次号 */
    private String traceCodeNumber;
    /** 生产批次号 */
    private String productBatchNo;
    /** 商品名称 */
    private String goodsName;
}
