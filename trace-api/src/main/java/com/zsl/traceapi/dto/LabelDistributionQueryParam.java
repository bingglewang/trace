package com.zsl.traceapi.dto;

import lombok.Data;

/**
 * @ClassName LabelDistributionQueryParam
 * @Description TODO
 * @Author binggleW
 * @Date 2020-07-22 17:14
 * @Version 1.0
 **/
@Data
public class LabelDistributionQueryParam {
    /**
     * 商家名称
     */
    private String merchantName;

    /**
     * 加盟商id
     */
    private Integer allianceId;
}
