package com.zsl.traceapi.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CH W
 * @description	新建生产批次时生产场景请求参数
 * @date 2020年6月3日 下午5:40:14
 * @version 1.0
 */
@Data
public class SceneForNewBatchParam {
	public interface Insert{
	}
	public interface Update{
	}
	
	@ApiModelProperty(value = "场景id")
	@NotNull(groups = {Insert.class, Update.class}, message = "sceneId不能空")
	@Min(groups = {Insert.class, Update.class}, value = 1, message = "sceneId参数违规")
	private Integer sceneId;
	
	@ApiModelProperty(value = "场景开始时间")
	private String startTime;
	
	@ApiModelProperty(value = "场景结束时间")
	private String endTime;
	
	@ApiModelProperty(value = "生产场景的员工id")
	private Integer employeId;
    
	@ApiModelProperty(value = "场景说明")
    private String description;
    
	@ApiModelProperty(value = "场景图片")
    private String[] imageUrls;
	
	@ApiModelProperty(value = "需要删除的生产场景图片")
	private Integer[] delImageIds;
    
	@ApiModelProperty(value = "场景视频")
    private String videoUrl;
    
	@ApiModelProperty(value = "原材料出库参数集合")
    private List<SourceMaterialParam> materialList;
    
}
