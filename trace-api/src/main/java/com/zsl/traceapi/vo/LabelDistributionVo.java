package com.zsl.traceapi.vo;

import lombok.Data;

/**
 * @ClassName LabelDistributionVo
 * @Description TODO
 * @Author binggleW
 * @Date 2020-07-22 17:08
 * @Version 1.0
 **/
@Data
public class LabelDistributionVo {
    private Integer businessId;
    private Long freeCount;
    private Long enabledCount;
    private Long usedPaperCount;
    private Long usedElectrCount;
    private String merchantName;
    private String companyName;
}
