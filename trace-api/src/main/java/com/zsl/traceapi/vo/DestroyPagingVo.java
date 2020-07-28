package com.zsl.traceapi.vo;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @remark 销毁分页数据
 * @author CH W
 * @date 2020年7月24日 下午5:36:16
 * @version 1.0
 */
@Data
public class DestroyPagingVo {
	
	@ApiModelProperty(value = "召回处理id")
	private Integer recallDisposeId;
	
	@ApiModelProperty(value = "处理批次号")
	private String disposeBatchNo;
	
	@ApiModelProperty(value = "商品名称")
	private String goodsName;
	
	@ApiModelProperty(value = "处理数量")
	private Integer disposeCount;
	
	@ApiModelProperty(value = "处理地点")
	private String disposeSite;
	
	@ApiModelProperty(value = "处理员工")
	private String employeName;
	
	@ApiModelProperty(value = "处理时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String createTime;
	
	@ApiModelProperty(value = "处理码段数据文件url")
	private String excelFileUrl;

}