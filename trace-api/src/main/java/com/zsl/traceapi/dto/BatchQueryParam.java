package com.zsl.traceapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author CH W
 * @description 查询场景列表参数
 * @date 2020年6月4日 上午11:53:37
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BatchQueryParam extends PagingParam {
	/**
	 * --商家端
	 */
	public interface Merchant{
	}
	
	/**
	 * --商家id
	 */
	@NotNull(groups = {Merchant.class}, message = "merchantId不能空")
	@Min(value = 1, message = "merchantId参数违规，请检查")
	private Integer merchantId;
	/**
	 * --生产批次号
	 */
	private String batchNo;
	/**
	 * --商品名称
	 */
	private String goodsName;
	/**
	 * --商家名称
	 */
	private String merchantName;

}
