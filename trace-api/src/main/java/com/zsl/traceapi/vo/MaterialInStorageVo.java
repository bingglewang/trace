package com.zsl.traceapi.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class MaterialInStorageVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "入库id")
    private Integer id;

    @ApiModelProperty(value = "入库批次号（规则:YCL20200912+入库表主键id）")
    private String inStorageBatchNo;

    @ApiModelProperty(value = "材料名称")
    private String materialName;
    
    @ApiModelProperty(value = "入库时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "库房编号")
    private String warehouseNumber;

    @ApiModelProperty(value = "剩余库存")
    private Integer residueStock;
    
    @ApiModelProperty(value = "材料单位")
    private String unit;

    @ApiModelProperty(value = "材料供应商")
    private String supplier;

}