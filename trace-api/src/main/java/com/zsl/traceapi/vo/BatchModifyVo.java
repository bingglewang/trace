package com.zsl.traceapi.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class BatchModifyVo {
	
	@ApiModelProperty(value = "批次id")
    private Integer batchId;

    @ApiModelProperty(value = "生产批次号")
    private String batchNo;
    
    @ApiModelProperty(value = "商品id")
    private Integer goodsId;
    
    @ApiModelProperty(value = "商品名称")
    private String goodsName;
    
    @ApiModelProperty(value = "商家id")
    private Integer merchantId;
    
    @ApiModelProperty(value = "商家名称")
    private String merchantName;
    
    @ApiModelProperty(value = "生产批次下已关联的场景信息列表")
    private List<SceneForEditBatchVo> sfebvList;
    
    @ApiModelProperty(value = "生产批次下未关联的场景信息列表")
    private List<SceneForNewBatchVo> noBoundSceneList;
    
}