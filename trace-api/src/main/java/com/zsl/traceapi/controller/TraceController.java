package com.zsl.traceapi.controller;

import com.zsl.traceapi.dto.*;
import com.zsl.traceapi.service.TraceService;
import com.zsl.traceapi.util.Constant;
import com.zsl.traceapi.util.TreeNode;
import com.zsl.traceapi.util.TreeUtils;
import com.zsl.traceapi.vo.ZslTraceVo;
import com.zsl.tracecommon.CommonPage;
import com.zsl.tracecommon.CommonResult;
import com.zsl.tracedb.mapper.AllianceBusinessMapper;
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

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "TraceController", description = "追溯模块")
@RestController
@RequestMapping("/trace")
public class TraceController {

    @Autowired
    private TraceService traceService;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private AllianceBusinessMapper allianceBusinessMapper;

    @Autowired
    private ZslTracePointMapper zslTracePointMapper;

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
    public CommonResult<CommonPage<ZslTraceVo>> getZslTraceByPage(QueryParam query, @Valid PageParams pageParams, BindingResult bindingResult) {
        if (pageParams.getPageNum() == null || pageParams.getPageNum() == 0) {
            pageParams.setPageNum(1); //默认从第1页开始
        }
        if (pageParams.getPageSize() == null || pageParams.getPageSize() == 0) {
            pageParams.setPageSize(10);//默认页面大小为10
        }
        List<ZslTraceVo> result = traceService.getZslTraceByPage(query, pageParams);
        return CommonResult.success(CommonPage.restPage(result));
    }

    @PostMapping("/insert")
    @ApiOperation("新增追溯信息")
    @ResponseBody
    public CommonResult insert(@RequestBody @Valid ZslTraceAddAndUpdateParam zslTraceAddAndUpdateParam, BindingResult bindingResult) {
       String resultStr = "申请成功";
        if(zslTraceAddAndUpdateParam.getTraceApplyType() == 1 &&  zslTraceAddAndUpdateParam.getTraceApplyCount() - Constant.UPPER_LIMIT > 0){
            resultStr = "申请成功，免费标签超过额度，需要扣除积分";
        }
        ZslTrace insertParam = new ZslTrace();
        BeanUtils.copyProperties(zslTraceAddAndUpdateParam, insertParam);
        // 默认为待审核状态
        insertParam.setTraceHandleStatus(2);
        // 剩余数量（）
        insertParam.setTraceEnableCount(Integer.parseInt(zslTraceAddAndUpdateParam.getTraceApplyCount()+""));
        // 已经关联数量（0）
        insertParam.setTraceBack1(0);

        //根据商家id查询加盟商/公司
        Merchant merchant = merchantMapper.selectByPrimaryKey(insertParam.getTraceBusinessId());
        if (merchant == null) {
            return CommonResult.failed("商家不存在");
        }
        Integer jiamenId = merchant.getAllianceBusinessId();//加盟商id:如果为空则为总部，否则为对应的加盟商
        if (jiamenId == null) {
            insertParam.setTraceCompanyName(Constant.ZONGBU);
        } else {
            AllianceBusiness allianceBusiness = allianceBusinessMapper.selectByPrimaryKey(jiamenId);
            if (allianceBusiness != null) {
                insertParam.setTraceCompanyName(allianceBusiness.getAllianceBusinessName());
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
        } else {
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

    @ApiOperation("根据商品id和摊位id返回追溯点树结构")
    @GetMapping("/zPointTree")
    @ResponseBody
    public CommonResult buildZTPointTree(@ApiParam("商品id") @RequestParam(required = true) Integer goodsId, @ApiParam("摊位id") @RequestParam(required = true) Integer stallId) {
        ZslTracePointExample zslTracePointExample = new ZslTracePointExample();
        ZslTracePointExample.Criteria criteria = zslTracePointExample.createCriteria();
        if(goodsId != null) {
            criteria.andTraceGoodsIdEqualTo(goodsId);
        }
        if(stallId != null){
            criteria.andTraceStallIdEqualTo(stallId);
        }
        List<ZslTracePoint> listz = zslTracePointMapper.selectByExample(zslTracePointExample);
        List<TreeNode> treeNodes = new ArrayList<>();
        for(ZslTracePoint item: listz){
            TreeNode node = new TreeNode();
            BeanUtils.copyProperties(item,node);
            treeNodes.add(node);
        }
        try {
          List<TreeNode> list =   TreeUtils.buildTree(treeNodes,"com.zsl.traceapi.util.TreeNode","tracePointId","traceParentId","children");
          return CommonResult.success(list);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed();
        }
    }

    /**
     * 追溯编码导出
     * @param
     * @return
     */
    @GetMapping("/point/export")
    @ApiOperation(value = "追溯编码导出")
    public CommonResult exportPointCode(@ApiParam("追溯码批次号") @RequestParam(required = true) String traceCode,HttpServletResponse response) {
        FileInfo fileInfo = traceService.exportPointCode(traceCode,response);
        if(fileInfo == null){
            return CommonResult.failed( "追溯码不存在或申请数量为0");
        }else{
            return  CommonResult.success(fileInfo, "追溯编码导出成功");
        }
    }


}
