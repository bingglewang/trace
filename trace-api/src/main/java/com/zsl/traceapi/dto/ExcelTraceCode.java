package com.zsl.traceapi.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ExcelTraceCode implements Serializable{

    /**
     * 姓名
     */
    @Excel(name="追溯码")
    @NotNull(message = "追溯码不能为空!")
    private String code;

    public ExcelTraceCode() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
