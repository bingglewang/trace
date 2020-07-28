package com.zsl.traceapi.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DisposeDetailVo {
	
	@ApiModelProperty(value = "处理方式中文")
	private String disposeTypeCN;
	
	public void setDisposeType(Integer disposeType) {
		this.disposeType = disposeType;
		if(disposeType!=null) {
			this.disposeTypeCN = disposeType==0 ? "销毁" : "继续销售";
		}
	}
	@ApiModelProperty(value = "处理方式")
	private Integer disposeType;
	
	@ApiModelProperty(value = "处理数量")
	private Integer disposeCount;
	
	@ApiModelProperty(value = "处理员工")
	private String employeName;
	
	@ApiModelProperty(value = "处理时间范围")
	private String disposeTimeScope;
    
	@ApiModelProperty(value = "处理地点")
    private String disposeSite;
    
	@ApiModelProperty(value = "处理说明")
    private String description;
	
	@ApiModelProperty(value = "追溯码excel文件url")
    private String excelFileUrl;

}