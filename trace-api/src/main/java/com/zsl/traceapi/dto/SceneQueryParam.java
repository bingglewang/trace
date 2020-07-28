package com.zsl.traceapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author CH W
 * @description 查询场景列表条件参数
 * @date 2020年6月4日 上午11:53:37
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class SceneQueryParam extends PagingParam {
	/**
	 * --商品id
	 */
	@NotNull(message = "goodsId不能空")
	@Min(value = 1, message = "goodsId参数违规，请检查")
	private Integer goodsId;
	/**
	 * --场景名称
	 */
	private String name;

}
