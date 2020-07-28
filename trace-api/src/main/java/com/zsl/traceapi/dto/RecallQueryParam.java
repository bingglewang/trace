package com.zsl.traceapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author CH W
 * @description	批次召回请求参数
 * @date 2020年6月3日 下午5:40:14
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RecallQueryParam extends PagingParam {
	
	@ApiModelProperty(value = "商家id")
	@NotNull(message = "merchantId不能空")
	@Min(value = 1, message = "merchantId参数违规")
	private Integer merchantId;
	
	@ApiModelProperty(value = "生产批次号")
	private String batchNo;
	
}
