package com.zsl.traceapi.service;

import com.zsl.traceapi.dto.*;
import com.zsl.traceapi.vo.ZslTraceVo;
import com.zsl.tracedb.model.ZslTrace;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface TraceService {
    /**
     * 根据id获取追溯
     * @param id
     * @return
     */
    ZslTraceVo getZslTraceById(Integer id);

    /**
     * 分页查询追溯信息
     * @param queryParam
     * @param pageParams
     * @return
     */
    List<ZslTraceVo> getZslTraceByPage(QueryParam queryParam, PageParams pageParams);

    /**
     * 新增追溯信息
     * @param zslTrace
     * @return
     */
    @Transactional
    ZslTrace insert(ZslTrace zslTrace);

    /**
     *更新追溯信息
     * @param zslTrace
     * @return
     */
    @Transactional
    int update(ZslTrace zslTrace);

    /**
     * 通过申请
     * @param id
     * @return
     */
    @Transactional
    int pass(Integer id);

    /**
     * 拒绝申请
     * @param id
     * @param remark
     * @return
     */
    @Transactional
    int refuse(Integer id,String remark);

    /**
     * 插入追溯记录(批量插入)
     * @param traceRecordInsertParamList
     * @return
     */
    @Transactional
    int traceRecordInsert(List<TraceRecordInsertParam> traceRecordInsertParamList);

    /**
     * 新建追溯点
     * @param traceRecordPointParam
     * @return
     */
    @Transactional
    int traceRecordPointInsert(TraceRecordPointParam traceRecordPointParam);

    /**
     * 导出该追溯批次号申请的追溯码
     * @param traceCode
     * @return
     */
    FileInfo exportPointCode(String traceCode,HttpServletResponse response);

}
