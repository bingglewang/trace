package com.zsl.traceapi.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BatchPagingVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "批次id")
    private Integer batchId;

    @ApiModelProperty(value = "生产批次号")
    private String batchNo;
    
    @ApiModelProperty(value = "商品id")
    private Integer goodsId;
    
    @ApiModelProperty(value = "商品名称")
    private String goodsName;
    
    @ApiModelProperty(value = "追溯批次号和码段（SID范围）")
    private String sidScope;
    
    @ApiModelProperty(value = "批次生产时间段")
    private String productionTimeScope;

}