package com.zsl.traceapi.service;

import com.zsl.traceapi.dto.*;
import com.zsl.traceapi.vo.GoodsVo;
import com.zsl.traceapi.vo.TraceRecordVo;
import com.zsl.traceapi.vo.ZslTraceVo;
import com.zsl.tracecommon.CommonResult;
import com.zsl.tracedb.model.Goods;
import com.zsl.tracedb.model.ZslTrace;
import com.zsl.tracedb.model.ZslTraceSid;
import com.zsl.tracedb.model.ZslTraceSubcode;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface TraceService {
    /**
     * 纸质标签预生成
     * @param preCreateCount
     * @return
     */
    CommonResult preCreatePaperCode(Long preCreateCount);
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
    List<ZslTraceVo> getZslTraceByPage(QueryParam queryParam, PageParams pageParams, HttpServletRequest request);

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
    int pass(Integer id,Long sid);

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
    int exportPointCode(String traceCode,HttpServletResponse response);

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

    /**
     * 设置外码比例，生成外码
     * @param miniCodeInsertParams
     * @return
     */
    Object generateOutCode(List<MiniCodeInsertParam> miniCodeInsertParams);

    /**
     * 根据数量生成外码
     * @param count
     * @return
     */
    Object generateOutCodeByCount(Integer count);

    /**
     * 关联外码
     * @param outCode
     * @param subCodeList
     * @return
     */
    CommonResult relationOutCode(String outCode,List<String> subCodeList);

    /**
     * 单独内码变外码
     * @param outCode
     * @return
     */
    int changeOutCode(String outCode);

    /**
     * 批量内码转外码
     * @param outCodeBatch
     * @return
     */
    CommonResult changOutCodeBatch(OutCodeBatch outCodeBatch);

    /**
     * 发货
     * @param deliverGoods
     * @return
     */
    int deliverGoods(DeliverGoods deliverGoods);

    /**
     * 插入扫码记录
     * @param scanRecordInsertParam
     * @return
     */
    int insertScanRecord(ScanRecordInsertParam scanRecordInsertParam);

    /**
     * 根据sid获取扫码记录
     * @param sid
     * @return
     */
    List<ScanRecordQueryParam> getScanRecordBySid(Long sid);

    /**
     * 根据sid获取追溯信息
     * @param sid
     * @return
     */
    CommonResult getTraceGoodInfo(Long sid,HttpServletRequest request);

    /**
     * 根据sid获取追溯码
     * @param sid
     * @return
     */
    CommonResult getSubCodeById(Long sid);

    /**
     * 分页获取外码和内码
     * @param traceSubCode
     * @return
     */
    CommonResult getIdByPage(String traceCodeNumber,String traceSubCode);

    /**
     * 根据sid获取追溯点记录
     * @param sid
     * @return
     */
    CommonResult getTracePointRecordBySid(Long sid);

    /**
     * 分页获取内码或外码树
     * @param pageNum
     * @param pageSize
     * @param traceCodeNumber
     * @return
     */
    CommonResult getSuCodeByPage(Integer pageNum,Integer pageSize,String traceCodeNumber);

    /**
     * 删除关联
     * @param id
     * @return
     */
    CommonResult deleteCodeRelation(Long id);

    /**
     * 根据数组获取树结构
     * @return
     */
    CommonResult getTreeListCode(RelationOutCode relationOutCode);

    /**
     * 判断是否扣除追溯记录积分
     * @return
     */
    int hasDeductionIntegral(TraceRecordPointParam traceRecordPointParam);

    /**
     * 根据sid获取覆盖码段
     * @param sid
     * @param traceId
     * @return
     */
    CommonResult getCodePartBySid(Long sid,Integer traceId);

    /**
     * 根据sid和追溯id获取覆盖码段
     * @param traceCodeNumber
     */
    CommonResult getNextSidByCodeNumber(String traceCodeNumber);
}
