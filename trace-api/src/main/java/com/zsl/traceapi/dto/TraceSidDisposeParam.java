package com.zsl.traceapi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CH W
 * @description	解析处理cvs文件中追溯码参数
 * @date 2020年6月3日 下午5:40:14
 * @version 1.0
 */
@Data
public class TraceSidDisposeParam {
	
	@ApiModelProperty(value = "召回id")
	@NotNull(message = "recallId不能空")
	@Min(value = 1, message = "recallId参数违规")
	private Integer recallId;
	
	@ApiModelProperty(value = "召回类型")
	@NotBlank(message = "recallType不能空")
	@Min(value = 0, message = "recallId参数违规")
	@Max(value = 1, message = "recallId参数违规")
	private Integer recallType;
	
	@ApiModelProperty(value = "解析的文件")
	@NotNull(message = "tmpFile不能空")
	private MultipartFile tmpFile;
    
}
