package com.zsl.traceapi.dao;

import java.util.List;

/**
 * @remark BaseDao
 * @author CH W
 * @date 2020年8月10日 下午5:09:46
 * @version 1.0
 */
public interface BaseDao<T> {

	/**
	 * --按条件查询记录列表
	 * @param param
	 * @return
	 */
	List<T> listByCondition(T condition);
	
}
