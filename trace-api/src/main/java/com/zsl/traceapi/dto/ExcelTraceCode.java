package com.zsl.traceapi.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ExcelTraceCode implements Serializable, IExcelModel, IExcelDataModel {

    /**
     * 序号
     */
    @Excel(name="序号",isImportField = "true")
    private String index;

    /**
     * 姓名
     */
    @Excel(name="追溯码",isImportField = "true")
    @NotNull(message = "追溯码不能为空!")
    private String code;


    /**
     * 接收返回的错误信息
     */
    private String errorMsg;

    /**
     * 接收excel行号
     */
    private int rowNum;


    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public int getRowNum() {
        return rowNum;
    }

    @Override
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum + 1;
    }

}
