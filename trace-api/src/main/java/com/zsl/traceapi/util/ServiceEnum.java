package com.zsl.traceapi.util;

public enum ServiceEnum {
    TRACE_RECORD(1,"申请追溯关联商品"),
    INSERT_TRACE_POINT(2,"新增追溯节点"),
    APPLY_PAPER(3,"申请纸质标签");

    private Integer id;
    private String value;

    ServiceEnum(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
