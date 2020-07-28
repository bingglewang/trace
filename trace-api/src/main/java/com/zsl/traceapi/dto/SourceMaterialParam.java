package com.zsl.traceapi.dto;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author CH W
 * @description 原材料出库参数
 * @date 2020年6月9日 下午5:46:00
 * @version 1.0
 */
@Data
public class SourceMaterialParam {
	/**
	 * --原材料入库id
	 */
	private Integer materialInId;
	/**
	 * --原材料入库批次号
	 */
	private String inStorageBatchNo;
	/**
	 * --出库数量
	 */
	private BigDecimal outStorageCount;
	/**
	 * --出库单号
	 */
	private String outOrderNo;
	/**
	 * --原材料单位
	 */
	private String unit;

}
