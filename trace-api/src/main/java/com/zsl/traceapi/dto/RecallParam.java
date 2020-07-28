package com.zsl.traceapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CH W
 * @description	批次召回请求参数
 * @date 2020年6月3日 下午5:40:14
 * @version 1.0
 */
@Data
public class RecallParam {
	public interface Insert{
	}
	public interface Update{
	}
	
	@ApiModelProperty(value = "召回id")
	@NotNull(groups = {Update.class}, message = "batchRecallId不能空")
	@Min(groups = {Update.class}, value = 1, message = "batchRecallId参数违规")
	private Integer batchRecallId;
	
	@ApiModelProperty(value = "生产批次号")
	@NotBlank(groups = Insert.class, message = "productionBatchNo不能空")
	private String productionBatchNo;
	
	@ApiModelProperty(value = "商品id")
	@NotNull(groups = {Insert.class}, message = "goodsId不能空")
	@Min(groups = {Insert.class}, value = 1, message = "goodsId参数违规")
	private Integer goodsId;
    
	@ApiModelProperty(value = "召回原因")
	@Length(max = 300, groups = {Insert.class, Update.class}, message = "cause内容过长，300个字符内")
    private String cause;
    
	@ApiModelProperty(value = "召回负责人")
	@NotBlank(groups = {Insert.class, Update.class}, message = "principal不能空")
    private String principal;
    
	@ApiModelProperty(value = "负责人手机")
	@NotBlank(groups = {Insert.class, Update.class}, message = "principalPhone不能空")
    private String principalPhone;
    
}
