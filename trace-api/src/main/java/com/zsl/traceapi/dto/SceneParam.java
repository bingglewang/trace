package com.zsl.traceapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CH W
 * @description	新建/编辑生产场景请求参数
 * @date 2020年6月3日 下午5:40:14
 * @version 1.0
 */
@Data
public class SceneParam {
	public interface Insert{
	}
	public interface Update{
	}
	
	@ApiModelProperty(value = "场景id")
	@NotNull(groups = Update.class, message = "sceneId不能空")
	@Min(groups = Update.class, value = 1, message = "sceneId参数违规")
	private Integer sceneId;
	
	@ApiModelProperty(value = "商品id")
	@NotNull(groups = {Insert.class}, message = "goodsId不能空")
	@Min(groups = {Insert.class}, value = 1, message = "goodsId参数违规")
	private Integer goodsId;
    
	@ApiModelProperty(value = "场景名称")
	@NotBlank(groups = {Insert.class}, message = "name不能空")
	@Length(groups = {Insert.class}, min = 1, max = 20, message = "name长度应为1-20个字符之间")
    private String name;
    
	@ApiModelProperty(value = "场景说明")
    private String description;
    
	@ApiModelProperty(value = "场景排序")
	@NotNull(groups = {Insert.class, Update.class}, message = "sceneSort不能空")
	@Min(groups = {Insert.class, Update.class}, value = 0, message = "sceneSort参数违规")
    private Integer sceneSort;
    
	@ApiModelProperty(value = "场景图片")
    private String[] imageUrls;
	
	@ApiModelProperty(value = "需要删除的生产场景图片")
	private Integer[] delImageIds;
    
	@ApiModelProperty(value = "场景视频")
    private String videoUrl;
    
}
