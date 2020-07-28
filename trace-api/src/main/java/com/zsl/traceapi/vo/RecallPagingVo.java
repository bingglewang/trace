package com.zsl.traceapi.vo;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RecallPagingVo {
	
	@ApiModelProperty(value = "召回id")
	private Integer recallId;
	
	@ApiModelProperty(value = "生产批次号")
	private String productionBatchNo;
	
	@ApiModelProperty(value = "商品名称")
	private String goodsName;
	
	@ApiModelProperty(value = "召回数量")
	private String recallCount;
    
	@ApiModelProperty(value = "召回原因")
    private String cause;
	
	@ApiModelProperty(value = "召回时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String createTime;
    
	@ApiModelProperty(value = "未处理数量")
    private Integer undisposedCount;
    
	@ApiModelProperty(value = "处理状态（1未处理、2已处理、3部分处理）")
    private Integer disposeStatus;
	
	@ApiModelProperty(value = "处理状态中文")
    private String disposeStatusCN;
	
	/**
	 * --处理状态中文
	 * @param disposeStatus
	 */
	public void setDisposeStatus(Integer disposeStatus) {
		this.disposeStatus = disposeStatus;
		if(disposeStatus!=null) {
			if(disposeStatus==1) {
				disposeStatusCN = "未处理";
			}else if(disposeStatus==2) {
				disposeStatusCN = "已处理";
			}else if(disposeStatus==3) {
				disposeStatusCN = "部分处理";
			}
		}
	}

}