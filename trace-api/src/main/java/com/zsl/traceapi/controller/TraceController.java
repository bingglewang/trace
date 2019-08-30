package com.zsl.traceapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.zsl.traceapi.config.kafka.producer.TraceUpdateProducerKafka;
import com.zsl.traceapi.config.rabbitmq.producer.TraceUpdateProducer;
import com.zsl.traceapi.context.RequestContext;
import com.zsl.traceapi.context.RequestContextMgr;
import com.zsl.traceapi.dao.ZslTraceDao;
import com.zsl.traceapi.dto.*;
import com.zsl.traceapi.service.TraceService;
import com.zsl.traceapi.util.Constant;
import com.zsl.traceapi.util.TreeNode;
import com.zsl.traceapi.util.TreeUtils;
import com.zsl.traceapi.vo.TracePointTreeVo;
import com.zsl.traceapi.vo.TraceRecordVo;
import com.zsl.traceapi.vo.ZslTraceVo;
import com.zsl.tracecommon.CommonPage;
import com.zsl.tracecommon.CommonResult;
import com.zsl.tracedb.mapper.AllianceBusinessMapper;
import com.zsl.tracedb.mapper.GoodsMapper;
import com.zsl.tracedb.mapper.MerchantMapper;
import com.zsl.tracedb.mapper.ZslTracePointMapper;
import com.zsl.tracedb.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

@Api(tags = "TraceController", description = "追溯模块")
@RestController
@RequestMapping("/trace")
public class TraceController {

    @Autowired
    private TraceService traceService;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private AllianceBusinessMapper allianceBusinessMapper;

    @Autowired
    private ZslTracePointMapper zslTracePointMapper;

    @Autowired
    private TraceUpdateProducer traceUpdateProducer;

    @GetMapping("/{id:[0-9]+}")
    @ApiOperation("根据id获取追溯信息")
    @ResponseBody
    public CommonResult getById(@PathVariable Integer id) {
        ZslTraceVo result = traceService.getZslTraceById(id);
        if (result != null) {
            return CommonResult.success(result);
        } else {
            return CommonResult.success(null, "没有查到该追溯信息");
        }
    }

    @ApiOperation(value = "分页获取追溯信息")
    @GetMapping("/getByPage")
    @ResponseBody
    public CommonResult<CommonPage<ZslTraceVo>> getZslTraceByPage(QueryParam query, @Valid PageParams pageParams,HttpServletRequest request, BindingResult bindingResult) {
        if (pageParams.getPageNum() == null || pageParams.getPageNum() == 0) {
            pageParams.setPageNum(1); //默认从第1页开始
        }
        if (pageParams.getPageSize() == null || pageParams.getPageSize() == 0) {
            pageParams.setPageSize(10);//默认页面大小为10
        }
        List<ZslTraceVo> result = traceService.getZslTraceByPage(query, pageParams,request);
        return CommonResult.success(CommonPage.restPage(result));
    }


    /**
     * 搜索获取外码和内码
     * @return
     */
    @GetMapping("/searchSubCodeTree")
    @ResponseBody
    public CommonResult getIdByPage(String traceCodeNumber, String sidOrSubCode) {
        return traceService.getIdByPage(traceCodeNumber,sidOrSubCode);
    }


    /**
     * 分页获取内码或外码
     * @return
     */
    @GetMapping("/getSuCodeByPage")
    @ResponseBody
    public CommonResult getSuCodeByPage(String traceCodeNumber,Integer pageNum,Integer pageSize) {
        return traceService.getSuCodeByPage(pageNum,pageSize,traceCodeNumber);
    }

    @ApiOperation(value = "分页获取追溯记录")
    @GetMapping("/getTraceRecordByPage")
    @ResponseBody
    public CommonResult<CommonPage<TraceRecordVo>> getTraceRecordByPage(String traceCodeNumber, @Valid PageParams pageParams, BindingResult bindingResult) {
        if (pageParams.getPageNum() == null || pageParams.getPageNum() == 0) {
            pageParams.setPageNum(1); //默认从第1页开始
        }
        if (pageParams.getPageSize() == null || pageParams.getPageSize() == 0) {
            pageParams.setPageSize(10);//默认页面大小为10
        }
        List<TraceRecordVo> result = traceService.getTraceRecodeByCode(traceCodeNumber, pageParams);
        return CommonResult.success(CommonPage.restPage(result));
    }


    @ApiOperation(value = "首页商家追溯排名")
    @GetMapping("/getBusiTraceRank")
    @ResponseBody
    public CommonResult<CommonPage<MerchantRankVo>> getBusiTraceRank(Integer companyId, Integer chartType, @Valid PageParams pageParams, BindingResult bindingResult) {
        if (pageParams.getPageNum() == null || pageParams.getPageNum() == 0) {
            pageParams.setPageNum(1); //默认从第1页开始
        }
        if (pageParams.getPageSize() == null || pageParams.getPageSize() == 0) {
            pageParams.setPageSize(10);//默认页面大小为10
        }
        List<MerchantRankVo> result = traceService.getBusiTraceRank(companyId,chartType, pageParams);
        return CommonResult.success(CommonPage.restPage(result));
    }

    @PostMapping("/insert")
    @ApiOperation("新增追溯信息")
    @ResponseBody
    public CommonResult insert(@RequestBody @Valid ZslTraceAddAndUpdateParam zslTraceAddAndUpdateParam, BindingResult bindingResult) {
       String resultStr = "申请成功";
        ZslTrace insertParam = new ZslTrace();
        BeanUtils.copyProperties(zslTraceAddAndUpdateParam, insertParam);
        // 默认为待审核状态
        insertParam.setTraceHandleStatus(2);
        // 剩余数量（）
        insertParam.setTraceEnableCount(Integer.parseInt(zslTraceAddAndUpdateParam.getTraceApplyCount()+""));
        // 已经关联数量（0）
        insertParam.setTraceBack1(0);

        //获取用户登录信息
        RequestContext requestContext = RequestContextMgr.getLocalContext();
        JSONObject loginUser = requestContext.getJsonObject();
        Integer accountType = Integer.parseInt(loginUser.get("accountType").toString());

        //根据商家id查询加盟商/公司
        Merchant merchant = merchantMapper.selectByPrimaryKey(insertParam.getTraceBusinessId());
        //判断是否需要扣除积分
        //Long totalApplyCount = zslTraceDao.busiTotalTraceCount(zslTraceAddAndUpdateParam.getTraceBusinessId());
        if(zslTraceAddAndUpdateParam.getTraceApplyType() == 1 &&  zslTraceAddAndUpdateParam.getTraceApplyCount() - merchant.getPaperLabelUpper() > 0){
            resultStr = "申请成功，免费标签超过额度，需要扣除积分";
        }
        if (merchant == null) {
            return CommonResult.failed("商家不存在");
        }else if(merchant.getCertificationToPay() != 1 && accountType == 2){
            return CommonResult.failed("商家没有认证");
        }
        Integer jiamenId = merchant.getAllianceBusinessId();//加盟商id:如果为空则为总部，否则为对应的加盟商
        if (jiamenId == null) {
            insertParam.setTraceCompanyName(Constant.ZONGBU);
            insertParam.setTraceBack2(null); //总部加盟商id
        } else {
            AllianceBusiness allianceBusiness = allianceBusinessMapper.selectByPrimaryKey(jiamenId);
            if (allianceBusiness != null) {
                //如果加盟商禁用，则属于总部
                if(allianceBusiness.getAllianceBusinessStatus() == 0){
                    insertParam.setTraceCompanyName(Constant.ZONGBU);
                    insertParam.setTraceBack2(null); //总部加盟商id
                }else{
                    insertParam.setTraceCompanyName(allianceBusiness.getAllianceBusinessName());
                    insertParam.setTraceBack2(allianceBusiness.getAllianceBusinessId());
                }
            } else {
                return CommonResult.failed("加盟商不存在");
            }
        }

        ZslTrace result = traceService.insert(insertParam);
        if (result != null) {
            return CommonResult.success(result, resultStr);
        } else {
            return CommonResult.failed("申请失败");
        }
    }

    @PutMapping("/{id:[0-9]+}")
    @ApiOperation("编辑追溯信息")
    @ResponseBody
    public CommonResult edit(@PathVariable Integer id, @RequestBody @Valid ZslTraceAddAndUpdateParam zslTraceAddAndUpdateParam, BindingResult bindingResult) {
        ZslTrace insertParam = new ZslTrace();
        BeanUtils.copyProperties(zslTraceAddAndUpdateParam, insertParam);
        insertParam.setTraceId(id);
        int i = traceService.update(insertParam);
        if (i > 0) {
            return CommonResult.success(null, "编辑成功");
        } else if(i == -2){
            return CommonResult.failed("追溯码不存在");
        }else if(i == -3){
            return CommonResult.failed("追溯信息已被处理,无法修改");
        }else{
            return CommonResult.failed("编辑失败");
        }
    }

    @PutMapping("/pass/{id:[0-9]+}")
    @ApiOperation("通过申请")
    @ResponseBody
    public CommonResult pass(@PathVariable Integer id) {
        int i = traceService.pass(id);
        if (i > 0) {
            return CommonResult.success(null, "通过成功");
        } else if (i == -1) {
            return CommonResult.failed("已经审核，不用重复审核");
        } else if (i == -2) {
            return CommonResult.failed("审核信息不存在");
        } else if (i == -3) {
            return CommonResult.failed("审核失败，服务器错误");
        }
        else if (i == -4) {
            return CommonResult.failed("积分不够，请进行充值");
        }
        else if (i == -5) {
            return CommonResult.failed("积分处理失败");
        }
        else if (i == -6) {
            return CommonResult.failed("积分扣除失败");
        }
        else if(i == -7){
            return CommonResult.failed("商家还未认证");
        }
        else if(i == -8){
            return CommonResult.failed("追溯码生成错误");
        }
        else {
            return CommonResult.failed("审核失败，服务器错误");
        }
    }

    @PutMapping("/cancel/{id:[0-9]+}")
    @ApiOperation("撤回申请")
    @ResponseBody
    public CommonResult cancel(@PathVariable Integer id) {
        int i = traceService.cancel(id);
        if (i > 0) {
            return CommonResult.success(null, "撤回成功");
        } else if (i == -1) {
            return CommonResult.failed("已经撤回，不用重复撤回");
        } else if (i == -2) {
            return CommonResult.failed("申请信息不存在");
        } else {
            return CommonResult.failed("撤回失败，服务器错误");
        }
    }


    @PutMapping("/refuse/{id:[0-9]+}")
    @ApiOperation("拒绝申请")
    @ResponseBody
    public CommonResult refuse(@PathVariable Integer id, @RequestParam String remark) {
        int i = traceService.refuse(id, remark);
        if (i > 0) {
            return CommonResult.success(null, "拒绝成功");
        } else if (i == -1) {
            return CommonResult.failed("已经审核，不用重复审核");
        } else if (i == -2) {
            return CommonResult.failed("审核信息不存在");
        } else {
            return CommonResult.failed("审核失败，服务器错误");
        }
    }


    @ApiOperation("批量添加追溯记录")
    @PostMapping("/record/batch")
    @ResponseBody
    public CommonResult recordInsertBatch(@RequestBody List<TraceRecordInsertParam> traceRecordInsertParamList) {
       String repeat = traceService.isCodeRepeat(traceRecordInsertParamList);
       if(!repeat.equals("编码没有冲突")){
           return CommonResult.failed(repeat);
       }
        int count = traceService.traceRecordInsert(traceRecordInsertParamList);
        if (count > 0) {
            return CommonResult.success(count);
        } else if (count == -1) {
            return CommonResult.failed("商品信息不存在");
        } else if (count == -2) {
            return CommonResult.failed("追溯码不存在");
        } else if(count == -3){
            return CommonResult.failed("追溯记录处理失败");
        }else if(count == -4){
            return CommonResult.failed("积分处理失败");
        }
        return CommonResult.failed();
    }

    @ApiOperation("新建追溯点")
    @PostMapping("/point")
    @ResponseBody
    public CommonResult pointInsert(@RequestBody TraceRecordPointParam traceRecordPointParam) {
        String repeat = traceService.isPointRepeat(traceRecordPointParam);
        if(!repeat.equals("编码没有冲突")){
            return CommonResult.failed(repeat);
        }
        int hasDeduct = traceService.hasDeductionIntegral(traceRecordPointParam);
        if(hasDeduct == -1){
            return CommonResult.failed("父节点错误");
        }else if(hasDeduct == -2){
            return CommonResult.failed("积分错误");
        }else if(hasDeduct == -3){
            return CommonResult.failed("请先扣除追溯记录积分");
        }
        int count = traceService.traceRecordPointInsert(traceRecordPointParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else if (count == -1) {
            return CommonResult.failed("商品信息不存在");
        } else if (count == -2) {
            return CommonResult.failed("父追溯点不存在");
        }
        else if (count == -3) {
            return CommonResult.failed("追溯码不存在");
        }
        else if (count == -4) {
            return CommonResult.failed("积分不够，请进行充值");
        }
        else if (count == -5) {
            return CommonResult.failed("追溯插入失败");
        }
        else if (count == -6) {
            return CommonResult.failed("积分扣除失败");
        }
        else if (count == -7) {
            return CommonResult.failed("积分日志处理失败");
        }
        return CommonResult.failed();
    }

    @ApiOperation("返回追溯点树结构")
    @GetMapping("/zPointTree")
    @ResponseBody
    public CommonResult buildZTPointTree(@ApiParam("摊位id") Integer stallId, @RequestParam(required = true) String  traceCodeNumber, HttpServletRequest request) {
        List<TracePointTreeVo> result = new ArrayList<>();
        Set<Integer> goodsIds = new HashSet<>();
        ZslTracePointExample zgoodsExample = new ZslTracePointExample();
        ZslTracePointExample.Criteria criteriaGoods = zgoodsExample.createCriteria();
        if(stallId == null || stallId == -1 ){  //非农贸,则根据追溯码获取商品id
            ZslTracePointExample.Criteria criteriaGoods1 = zgoodsExample.createCriteria();
            String goodsId = request.getParameter("goodsId");
            criteriaGoods.andTraceCodeNumberEqualTo(traceCodeNumber);
            criteriaGoods.andTraceStallIdEqualTo(-1);
            int goodsIdInt = 0;
            try{
                goodsIdInt = Integer.parseInt(goodsId);
            }catch (Exception e){

            }
            criteriaGoods.andTraceGoodsIdEqualTo(goodsIdInt);
            //或者
            criteriaGoods1.andTraceCodeNumberEqualTo(traceCodeNumber);
            criteriaGoods1.andTraceStallIdIsNull();
            criteriaGoods1.andTraceGoodsIdEqualTo(goodsIdInt);
            zgoodsExample.or(criteriaGoods1);
        }else{
            criteriaGoods.andTraceCodeNumberEqualTo(traceCodeNumber);
            criteriaGoods.andTraceStallIdEqualTo(stallId);
        }
        List<ZslTracePoint> goodsTraceList = zslTracePointMapper.selectByExample(zgoodsExample);
        for(ZslTracePoint zgoodsPoint : goodsTraceList){
            if(goodsIds.add(zgoodsPoint.getTraceGoodsId())){
                TracePointTreeVo tracePointTreeVo = new TracePointTreeVo();
                Goods tGoods = goodsMapper.selectByPrimaryKey(zgoodsPoint.getTraceGoodsId());
                if(tGoods != null){
                    tracePointTreeVo.setGoodsName(tGoods.getGoodsName());
                }
                ZslTracePointExample zslTracePointExample = new ZslTracePointExample();
                ZslTracePointExample.Criteria criteria = zslTracePointExample.createCriteria();
                if(stallId != null){
                    criteria.andTraceStallIdEqualTo(stallId);
                }else{
                    criteria.andTraceStallIdEqualTo(-1);
                    //或者
                    ZslTracePointExample.Criteria criteria1 = zslTracePointExample.createCriteria();
                    criteria1.andTraceCodeNumberEqualTo(traceCodeNumber);
                    criteria1.andTraceStallIdIsNull();
                    criteria1.andTraceGoodsIdEqualTo(zgoodsPoint.getTraceGoodsId());
                    zslTracePointExample.or(criteria1);
                }
                criteria.andTraceCodeNumberEqualTo(traceCodeNumber);
                criteria.andTraceGoodsIdEqualTo(zgoodsPoint.getTraceGoodsId());
                List<ZslTracePoint> listz = zslTracePointMapper.selectByExample(zslTracePointExample);

                List<TreeNode> treeNodes = new ArrayList<>();
                for(ZslTracePoint item: listz){
                    TreeNode node = new TreeNode();
                    BeanUtils.copyProperties(item,node);
                    treeNodes.add(node);
                }
                try {
                    List<TreeNode> list =   TreeUtils.buildTree(treeNodes,"com.zsl.traceapi.util.TreeNode","tracePointId","traceParentId","children");
                    tracePointTreeVo.setTreeNodes(list);
                }catch (Exception e){
                    e.printStackTrace();
                    return CommonResult.failed();
                }
                result.add(tracePointTreeVo);
            }
        }
        return CommonResult.success(result);
    }



    /**
     * 追溯编码导出
     * @param
     * @return
     */
    @GetMapping("/point/export")
    @ApiOperation(value = "追溯编码导出")
    public CommonResult exportPointCode(@ApiParam("追溯码批次号") @RequestParam(required = true) String traceCode,HttpServletResponse response) {
        int fileInfo = traceService.exportPointCode(traceCode,response);
        if(fileInfo == -1){
            return CommonResult.failed( "追溯码不存在");
        }else if(fileInfo == -2){
            return CommonResult.failed( "追溯码还未生成完");
        }else{
            return  CommonResult.success(fileInfo, "追溯编码导出成功");
        }
    }

    /**
     * 首页追溯数量
     * @param companyId
     * @return
     */
    @GetMapping("getTraceTotalCountAndYest")
    public CommonResult getTraceTotalCountAndPrice(Integer companyId){
        return CommonResult.success(traceService.getTraceTotalCountAndPrice(companyId));
    }

    /**
     * 首页图表统计
     * @param companyId
     * @return
     */
    @GetMapping("getChartData")
    public CommonResult getChartData(Integer companyId,Integer chartType){
        return CommonResult.success(traceService.getChartData(companyId,chartType));
    }

    /**
     * 首页饼图
     * @param companyId
     * @return
     */
    @GetMapping("getPieChart")
    public CommonResult getPieChart(Integer companyId){
        return CommonResult.success(traceService.getPieChart(companyId));
    }

    /**
     * 首页最新追溯申请记录
     * @return
     */
    @GetMapping("getNewTraceRecord")
    public CommonResult getNewTraceRecord(){
        return CommonResult.success(traceService.getNewTraceRecord());
    }

    /**
     * 首页本月追溯额
     * @return
     */
    @GetMapping("getMonthTrace")
    public CommonResult getMonthTrace(){
        return CommonResult.success(traceService.getMonthTrace());
    }

    /**
     * 根据追溯码获取商品列表
     * @param
     * @return
     */
    @GetMapping("/getGoodsListByTraceCode")
    public CommonResult getGoodsListByTraceCode(String traceCodeNumber) {
         return CommonResult.success( traceService.getGoodsByTraceCodeNumber(traceCodeNumber));
    }


    @ApiOperation("设置生成外码")
    @PostMapping("/generateOutCode")
    @ResponseBody
    public CommonResult generateOutCode(@RequestBody List<MiniCodeInsertParam> miniCodeList) {
        Object object  = traceService.generateOutCode(miniCodeList);
        if(object == null){
            return CommonResult.failed("生成失败");
        }else{
            return CommonResult.success(object,"生成成功");
        }
    }


    /**
     * 根据数量生成外码
     * @param count
     * @return
     */
    @GetMapping("/generateOutCodeByCount")
    @ResponseBody
    public CommonResult generateOutCodeByCount(Integer count){
        Object object = traceService.generateOutCodeByCount(count);
        if(object == null){
            return CommonResult.failed("生成失败");
        }else{
            return CommonResult.success(object,"生成成功");
        }
    }

    /**
     * 外码关联子码
     * @param relationOutCode
     * @return
     */
    @PostMapping("/relationOutCode")
    @ResponseBody
    public CommonResult relationOutCode(@RequestBody RelationOutCode relationOutCode){
        return traceService.relationOutCode(relationOutCode.getOutCode(),relationOutCode.getSubCodeList());
    }


    /**
     * 单独内码转外码
     * @param outCode
     * @return
     */
        @GetMapping("/changeOutCode")
    @ResponseBody
    public CommonResult changeOutCode(String outCode){
        int  i = traceService.changeOutCode(outCode);
        if(i == -1){
            return CommonResult.failed("该码已经为外码");
        }else if(i == -2){
            return CommonResult.failed("转换失败");
        }else if(i == -3){
            return CommonResult.failed("编码不存在");
        }else if(i == -4){
            return CommonResult.failed("该批次号不能在小程序端操作");
        }else if(i == -5){
            return CommonResult.failed("该码已经发过货了");
        }else if(i == -6){
            return CommonResult.failed("只能操作自己追溯码");
        }else{
            return CommonResult.success("转换成功");
        }
    }

    /**
     * 批量内码转外码
     * @param outCodeBatch
     * @return
     */
    @PostMapping("/changOutCodeBatch")
    public CommonResult changOutCodeBatch(@RequestBody  OutCodeBatch outCodeBatch){
        return traceService.changOutCodeBatch(outCodeBatch);
    }

    /**
     * 发货
     * @return
     */
    @PostMapping("/deliverGoods")
    public CommonResult deliverGoods(@RequestBody DeliverGoods deliverGoods){
        int i = traceService.deliverGoods(deliverGoods);
        if(i > 0){
            return CommonResult.success("发货成功");
        }else if(i == -2){
            return CommonResult.failed("外码还没有关联内码");
        }else if(i == -3){
            return CommonResult.failed("请先关联内码");
        }else if(i == -4){
            return CommonResult.failed("不要重复发货");
        }else if(i == -5){
            return CommonResult.failed("发货码为空");
        }else if(i == -6){
            return CommonResult.failed("只能操作自己追溯码");
        }else if(i == -7){
            return CommonResult.failed("积分不够，请进行充值");
        }
        else if(i == -8){
            return CommonResult.failed("追溯码不存在");
        }
        else{
            return CommonResult.failed("发货失败");
        }
    }

    /**
     * 根据sid获取追溯码
     * @param sid
     * @return
     */
    @GetMapping("getSubCodeById")
    public CommonResult getSubCodeById(Long sid){
        return traceService.getSubCodeById(sid);
    }

    /**
     * 插入扫码记录
     * @param scanRecordInsertParam
     * @return
     */
    @PostMapping("insertScanRecord")
    public CommonResult insertScanRecord(@RequestBody ScanRecordInsertParam scanRecordInsertParam){
        int i = traceService.insertScanRecord(scanRecordInsertParam);
        if(i > 0){
            return CommonResult.success("操作成功");
        }else{
            return CommonResult.failed();
        }
    }

    /**
     * 根据sid获取扫码记录
     * @param sid
     * @return
     */
    @GetMapping("getScanRecordBySid")
    public CommonResult getScanRecordBySid(Long sid){
        return CommonResult.success(traceService.getScanRecordBySid(sid));
    }

    /**
     * 根据sid获取追溯信息
     * @param sid
     * @return
     */
    @GetMapping("getTraceGoodInfo")
    public CommonResult getTraceGoodInfo(Long sid,HttpServletRequest request){
        return traceService.getTraceGoodInfo(sid,request);
    }

    /**
     * 删除关联
     * @return
     */
    @PostMapping("deleteCode/{id:[0-9]+}")
    public CommonResult deleteCodeRelation(@PathVariable Long id){
        return traceService.deleteCodeRelation(id);
    }

    /**
     * 根据追溯码数组获取树结构
     * @return
     */
    @PostMapping("getTreeListCode")
    public CommonResult getTreeListCode(@RequestBody RelationOutCode relationOutCode){
        return traceService.getTreeListCode(relationOutCode);
    }

    /**
     * 根据sid获取追溯点记录
     * @param sid
     * @return
     */
    @GetMapping("getTracePointRecordBySid")
    public  CommonResult getTracePointRecordBySid(Long sid){
        return traceService.getTracePointRecordBySid(sid);
    }

    /**
     * mq关联子码(积分扣除的时候调用)
     * @return
     */
    @PostMapping("relationMqSubCode")
    public CommonResult relationMqSubCode(@RequestBody RelationMqSuCodeParam relationMqSuCodeParam){
        try {
            traceUpdateProducer.sendMessage(relationMqSuCodeParam.getMqJsonStr(),100);
            return CommonResult.success("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("发送失败");
        }
    }
}

