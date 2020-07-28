package com.zsl.traceapi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CH W
 * @description	处理召回请求参数
 * @date 2020年6月3日 下午5:40:14
 * @version 1.0
 */
@Data
public class DisposeRecallParam {
	
	@ApiModelProperty(value = "处理方式")
	@NotNull(message = "disposeType不能空")
	@Min(value = 0, message = "disposeType参数违规")
	@Max(value = 1, message = "disposeType参数违规")
	private Integer disposeType;
	
	@ApiModelProperty(value = "员工id")
	@NotNull(message = "employeId不能空")
	@Min(value = 1, message = "employeId参数违规")
	private Integer employeId;
	
	@ApiModelProperty(value = "开始时间")
	@NotBlank(message = "startTime不能空")
	private String startTime;
    
	@ApiModelProperty(value = "结束时间")
	@NotBlank(message = "startTime不能空")
    private String endTime;
    
	@ApiModelProperty(value = "处理地点")
	@NotBlank(message = "disposeSite不能空")
    private String disposeSite;
    
	@ApiModelProperty(value = "处理说明")
    private String description;
	
	@ApiModelProperty(value = "追溯码excel文件url")
	@NotBlank(message = "excelFileUrl不能空")
    private String excelFileUrl;
	
	@ApiModelProperty(value = "处理数量")
	@NotNull(message = "disposeCount不能空")
	@Min(value = 1, message = "disposeCount参数违规")
    private Integer disposeCount;
    
}
