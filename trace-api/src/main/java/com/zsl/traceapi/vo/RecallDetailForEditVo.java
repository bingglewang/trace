package com.zsl.traceapi.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RecallDetailForEditVo {
	
	@ApiModelProperty(value = "召回id")
	private Integer recallId;
	
	@ApiModelProperty(value = "生产批次号")
	private String productionBatchNo;
	
	@ApiModelProperty(value = "商品名称")
	private String goodsName;
    
	@ApiModelProperty(value = "召回原因")
    private String cause;
    
	@ApiModelProperty(value = "召回负责人")
    private String principal;
    
	@ApiModelProperty(value = "负责人手机")
    private String principalPhone;

}