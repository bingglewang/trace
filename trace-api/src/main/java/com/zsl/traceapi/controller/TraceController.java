package com.zsl.traceapi.controller;

import com.github.pagehelper.PageInfo;
import com.zsl.traceapi.dto.PageParams;
import com.zsl.traceapi.dto.QueryParam;
import com.zsl.traceapi.dto.ZslTraceAddAndUpdateParam;
import com.zsl.traceapi.service.TraceService;
import com.zsl.traceapi.util.Constant;
import com.zsl.traceapi.vo.ZslTraceVo;
import com.zsl.tracecommon.CommonPage;
import com.zsl.tracecommon.CommonResult;
import com.zsl.tracedb.mapper.AllianceBusinessMapper;
import com.zsl.tracedb.mapper.MerchantMapper;
import com.zsl.tracedb.model.AllianceBusiness;
import com.zsl.tracedb.model.Merchant;
import com.zsl.tracedb.model.ZslTrace;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "TraceController", description = "追溯模块")
@RestController("/trace")
public class TraceController {

    @Autowired
    private TraceService traceService;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private AllianceBusinessMapper allianceBusinessMapper;

    @GetMapping("/{id:[0-9]+}")
    @ApiOperation("根据id获取追溯信息")
    @ResponseBody
    public CommonResult getById(@PathVariable Integer id ){
        ZslTraceVo result =  traceService.getZslTraceById(id);
        if(result != null){
            return  CommonResult.success(result);
        }else{
            return  CommonResult.success(null,"没有查到该追溯信息");
        }
    }

    @ApiOperation(value = "分页获取追溯信息")
    @GetMapping("/getByPage")
    @ResponseBody
    public CommonResult<CommonPage<ZslTraceVo>> getZslTraceByPage(QueryParam query, @Valid PageParams pageParams, BindingResult bindingResult) {
        if(pageParams.getPageNum() == null || pageParams.getPageNum() == 0){
            pageParams.setPageNum(1); //默认从第1页开始
        }
        if(pageParams.getPageSize() == null || pageParams.getPageSize() == 0 ){
            pageParams.setPageSize(10);//默认页面大小为10
        }
        List<ZslTraceVo> result = traceService.getZslTraceByPage(query,pageParams);
        return CommonResult.success(CommonPage.restPage(result));
    }

    @PostMapping("/insert")
    @ApiOperation("新增追溯信息")
    @ResponseBody
    public CommonResult insert(@RequestBody @Valid ZslTraceAddAndUpdateParam zslTraceAddAndUpdateParam, BindingResult bindingResult){
        ZslTrace insertParam = new ZslTrace();
        BeanUtils.copyProperties(zslTraceAddAndUpdateParam,insertParam);
        // 默认为待审核状态
        insertParam.setTraceHandleStatus(2);

        //根据商家id查询加盟商/公司
        Merchant merchant =  merchantMapper.selectByPrimaryKey(insertParam.getTraceBusinessId());
        if(merchant == null){
            return  CommonResult.failed("商家不存在");
        }
        Integer jiamenId = merchant.getAllianceBusinessId();//加盟商id:如果为空则为总部，否则为对应的加盟商
        if(jiamenId == null){
            insertParam.setTraceCompanyName(Constant.ZONGBU);
        }else{
           AllianceBusiness allianceBusiness =  allianceBusinessMapper.selectByPrimaryKey(jiamenId);
           if(allianceBusiness != null){
               insertParam.setTraceCompanyName(allianceBusiness.getAllianceBusinessName());
           }else{
               return  CommonResult.failed("加盟商不存在");
           }
        }

        ZslTrace result =  traceService.insert(insertParam);
        if(result != null){
            return  CommonResult.success(result,"新增成功");
        }else{
            return  CommonResult.failed("新增失败");
        }
    }

    @PutMapping("/{id:[0-9]+}")
    @ApiOperation("编辑追溯信息")
    @ResponseBody
    public CommonResult edit(@PathVariable Integer id,@RequestBody @Valid ZslTraceAddAndUpdateParam zslTraceAddAndUpdateParam,BindingResult bindingResult){
        ZslTrace insertParam = new ZslTrace();
        BeanUtils.copyProperties(zslTraceAddAndUpdateParam,insertParam);
        insertParam.setTraceId(id);
        int  i =  traceService.update(insertParam);
        if(i > 0){
            return  CommonResult.success(null,"编辑成功");
        }else{
            return  CommonResult.failed("编辑失败");
        }
    }

    @PutMapping("/pass/{id:[0-9]+}")
    @ApiOperation("通过申请")
    @ResponseBody
    public CommonResult pass(@PathVariable Integer id){
        int  i =  traceService.pass(id);
        if(i > 0){
            return  CommonResult.success(null,"通过成功");
        }else if(i == -1){
            return  CommonResult.failed("已经审核，不用重复审核");
        }else if(i == -2){
            return  CommonResult.failed("审核信息不存在");
        }else {
            return  CommonResult.failed("审核失败，服务器错误");
        }
    }

    @PutMapping("/refuse/{id:[0-9]+}")
    @ApiOperation("拒绝申请")
    @ResponseBody
    public CommonResult refuse(@PathVariable Integer id,@RequestParam String remark){
        int  i =  traceService.refuse(id,remark);
        if(i > 0){
            return  CommonResult.success(null,"拒绝成功");
        }else if(i == -1){
            return  CommonResult.failed("已经审核，不用重复审核");
        }else if(i == -2){
            return  CommonResult.failed("审核信息不存在");
        }else {
            return  CommonResult.failed("审核失败，服务器错误");
        }
    }
}
