package com.zsl.traceapi.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MaterialOutStorageVo implements Serializable {
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "入库批次号（规则:YCL20200912+入库表主键id）")
    private String inStorageBatchNo;
    
    @ApiModelProperty(value = "出库数量")
    private Integer outStorageCount;

    @ApiModelProperty(value = "出库单号")
    private String outStorageNo;
    
    @ApiModelProperty(value = "材料名称")
    private String materialName;
    
    @ApiModelProperty(value = "入库时间")
    private Date createTime;

    @ApiModelProperty(value = "库房编号")
    private String storageNo;

    @ApiModelProperty(value = "材料供应商")
    private String materialSource;

    @ApiModelProperty(value = "剩余数量")
    private Integer surplusCount;

    @ApiModelProperty(value = "材料单位")
    private String unit;

}