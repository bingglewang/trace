package com.zsl.traceapi.service;

import com.zsl.traceapi.dto.*;
import com.zsl.traceapi.vo.GoodsVo;
import com.zsl.traceapi.vo.TraceRecordVo;
import com.zsl.traceapi.vo.ZslTraceVo;
import com.zsl.tracedb.model.Goods;
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
    ZslTrace insert(ZslTrace zslTrace);

    /**
     *更新追溯信息
     * @param zslTrace
     * @return
     */
    int update(ZslTrace zslTrace);

    /**
     * 通过申请
     * @param id
     * @return
     */
    int pass(Integer id);

    /**
     * 撤回申请
     * @param id
     * @return
     */
    int cancel(Integer id);

    /**
     * 拒绝申请
     * @param id
     * @param remark
     * @return
     */
    int refuse(Integer id,String remark);

    /**
     * 插入追溯记录(批量插入)
     * @param traceRecordInsertParamList
     * @return
     */
    int traceRecordInsert(List<TraceRecordInsertParam> traceRecordInsertParamList);

    /**
     * 新建追溯点
     * @param traceRecordPointParam
     * @return
     */
    int traceRecordPointInsert(TraceRecordPointParam traceRecordPointParam);

    /**
     * 导出该追溯批次号申请的追溯码
     * @param traceCode
     * @return
     */
    FileInfo exportPointCode(String traceCode,HttpServletResponse response);

    /**
     * 判断记录编码冲突
     * @param traceRecordInsertParamList
     * @return
     */
    String isCodeRepeat(List<TraceRecordInsertParam> traceRecordInsertParamList);

    /**
     * 判断追溯点编码冲突
     * @param traceRecordPointParam
     * @return
     */
    String isPointRepeat(TraceRecordPointParam traceRecordPointParam);

    /**
     * 获取总追溯数量和昨日追溯额
     * @return
     */
    Object getTraceTotalCountAndPrice(Integer companyId);

    /**
     * 首页图表统计
     * @param chartType
     * @return
     */
    Object getChartData(Integer companyId,Integer chartType);

    /**
     * 首页图表统计排名
     * @param companyId
     * @param chartType
     * @param pageParams
     * @return
     */
    List<MerchantRankVo> getBusiTraceRank(Integer companyId,Integer chartType,PageParams pageParams);

    /**
     * 首页饼图
     * @param companyId
     * @return
     */
    Object getPieChart(Integer companyId);

    /**
     * 首页最新申请记录
     * @return
     */
    Object getNewTraceRecord();

    /**
     * 本月追溯额
     * @return
     */
    Object getMonthTrace();

    /**
     * 根据追溯码获取追溯记录
     * @param traceCodeNumber
     * @return
     */
    List<TraceRecordVo> getTraceRecodeByCode(String traceCodeNumber, PageParams pageParams);

    /**
     * 根据追溯码获取商品列表
     * @param traceCodeNumber
     * @return
     */
    List<GoodsVo> getGoodsByTraceCodeNumber(String traceCodeNumber);
}
