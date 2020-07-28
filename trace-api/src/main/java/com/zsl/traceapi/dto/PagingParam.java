package com.zsl.traceapi.dto;

import lombok.Data;

/**
 * @author CH W
 * @description 分页查询参数抽象类
 * @date 2020年6月4日 上午11:50:28
 * @version 1.0
 */
@Data
public abstract class PagingParam {
	private int pageNum=1;
	private int pageSize=10;
	private String startTime;
	private String endTime;

}
