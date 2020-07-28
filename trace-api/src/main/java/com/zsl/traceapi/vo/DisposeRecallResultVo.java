package com.zsl.traceapi.vo;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DisposeRecallResultVo {
	
	@ApiModelProperty(value = "召回id")
	private Integer recallId;
	
	@ApiModelProperty(value = "生产批次号")
	private String productionBatchNo;
	
	@ApiModelProperty(value = "商品名称")
	private String goodsName;
	
	@ApiModelProperty(value = "召回数量")
	private Integer recallCount;
	
	@ApiModelProperty(value = "未处理数量")
	private Integer undisposeCount;
    
	@ApiModelProperty(value = "召回原因")
    private String cause;
	
	@ApiModelProperty(value = "处理召回详情列表")
    private List<DisposeDetailVo> ddvList;

}