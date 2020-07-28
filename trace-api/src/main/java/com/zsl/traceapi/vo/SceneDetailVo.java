package com.zsl.traceapi.vo;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SceneDetailVo {
	
	@ApiModelProperty(value = "场景id")
    private Integer sceneId;

    @ApiModelProperty(value = "场景名称")
    private String name;

    @ApiModelProperty(value = "当前状态（0禁用、1现启用、2历史启用）")
    private Integer currentStatus;
    
    @ApiModelProperty(value = "产品的场景排序")
    private Integer sceneSort;

    @ApiModelProperty(value = "视频链接url")
    private String videoUrl;

    @ApiModelProperty(value = "描述")
    private String description;
    
    @ApiModelProperty(value = "场景图片列表")
    private List<Map<String, Object>> sceneImages;
	
}