package com.zsl.traceapi.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ScenePagingVo {
	
	@ApiModelProperty(value = "场景id")
    private Integer sceneId;

    @ApiModelProperty(value = "场景名称")
    private String name;
    
    @ApiModelProperty(value = "产品的场景排序")
    private Integer sceneSort;

    @ApiModelProperty(value = "描述")
    private String description;
    
}