package com.zsl.traceapi.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CH W
 * @description 生产批次请求参数
 * @date 2020年6月9日 下午2:35:20
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchParam {
	public interface Insert{
	}
	public interface Update{
	}
	
	@ApiModelProperty(value = "生产批次id")
	@NotNull(groups = Update.class, message = "batchId不能空")
	@Min(groups = Update.class, value = 1, message = "batchId参数违规")
	private Integer batchId;
	
	@ApiModelProperty(value = "生产批次号")
	@NotBlank(groups = {Insert.class, Update.class}, message = "batchNo不能空")
    private String batchNo;
	
	@ApiModelProperty(value = "商家id")
	@NotNull(groups = {Insert.class}, message = "merchantId不能空")
	@Min(groups = {Insert.class}, value = 1, message = "merchantId参数违规")
	private Integer merchantId;
	
	@ApiModelProperty(value = "商品id")
	@NotNull(groups = {Insert.class}, message = "goodsId不能空")
	@Min(groups = {Insert.class}, value = 1, message = "goodsId参数违规")
	private Integer goodsId;
	
	@ApiModelProperty(value = "生产场景参数集合")
	private List<SceneForNewBatchParam> sceneList;
	
}
