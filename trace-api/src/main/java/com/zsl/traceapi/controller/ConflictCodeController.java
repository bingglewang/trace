package com.zsl.traceapi.controller;

import com.zsl.traceapi.dto.ConflictCodeDetailParam;
import com.zsl.traceapi.dto.ConflictCodeParam;
import com.zsl.traceapi.dto.PageParams;
import com.zsl.traceapi.dto.QueryParam;
import com.zsl.traceapi.service.ConflictCodeService;
import com.zsl.traceapi.vo.ZslTraceVo;
import com.zsl.tracecommon.CommonPage;
import com.zsl.tracecommon.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName ConflictCodeController
 * @Description 串货
 * @Author binggleW
 * @Date 2020-07-30 11:00
 * @Version 1.0
 **/
@RestController
@RequestMapping("conflict")
public class ConflictCodeController {

    @Autowired
    private ConflictCodeService conflictCodeService;

    /**
     * 分页获取串货列表
     * @param query
     * @param pageParams
     * @param bindingResult
     * @return
     */
    @GetMapping("/getByPage")
    @ResponseBody
    public Object getConflictCodeByPage(ConflictCodeParam query, @Valid PageParams pageParams, BindingResult bindingResult) {
        if (pageParams.getPageNum() == null || pageParams.getPageNum() == 0) {
            pageParams.setPageNum(1); //默认从第1页开始
        }
        if (pageParams.getPageSize() == null || pageParams.getPageSize() == 0) {
            pageParams.setPageSize(10);//默认页面大小为10
        }
        return conflictCodeService.getConflictCodeByPage(pageParams,query);
    }

    /**
     * 分页获取串货明细列表
     * @param id
     * @param query
     * @param pageParams
     * @param bindingResult
     * @return
     */
    @GetMapping("/getByPageDetail/{id:[0-9]+}")
    @ResponseBody
    public Object getConflictCodeDetailByPage(@PathVariable Integer id, ConflictCodeDetailParam query, @Valid PageParams pageParams, BindingResult bindingResult) {
        if (pageParams.getPageNum() == null || pageParams.getPageNum() == 0) {
            pageParams.setPageNum(1); //默认从第1页开始
        }
        if (pageParams.getPageSize() == null || pageParams.getPageSize() == 0) {
            pageParams.setPageSize(10);//默认页面大小为10
        }
        return conflictCodeService.getConflictCodeDetailByPage(pageParams,query,id);
    }

}
