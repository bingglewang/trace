package com.zsl.traceapi.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @remark 商品销售渠道信息视图数据
 * @author CH W
 * @date 2020年8月27日 下午3:28:20
 * @version 1.0
 */
@Data
public class GoodsSellChannelVo {
	//	商品id
	@NotNull(message = "goodsId不能为空")
	@Min(value = 1, message = "goodsId参数违规")
	private Integer goodsId;
	//	商品销售渠道id
	private Integer goodsSellChannelId;
	//	天猫
	private String tmall;
	//	京东
	private String jd;
	//	淘宝
	private String taobao;
	
}
