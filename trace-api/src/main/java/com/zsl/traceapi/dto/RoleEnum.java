package com.zsl.traceapi.dto;

public enum  RoleEnum {
    ROLE_SYSTEM_ADMIN(1,"ROLE_SYSTEM_ADMIN","系统管理员"),
    ROLE_HEADQUARTERS_ADMIN(2,"ROLE_HEADQUARTERS_ADMIN","总部管理员"),
    ROLE_HEADQUARTERS_OPERATE(3,"ROLE_HEADQUARTERS_OPERATE","总部运营"),
    ROLE_HEADQUARTERS_FINANCE(4,"ROLE_HEADQUARTERS_FINANCE","总部财务"),
    ROLE_FRANCHISEE_ADMIN(5,"ROLE_FRANCHISEE_ADMIN","加盟商管理员"),
    ROLE_FRANCHISEE_OPERATE(6,"ROLE_FRANCHISEE_OPERATE","加盟商运营"),
    ROLE_FRANCHISEE_FINANCE(7,"ROLE_FRANCHISEE_FINANCE","加盟商财务"),
    ROLE_BUSINESS(8,"ROLE_BUSINESS","商家"),
    ROLE_BUSINESS_STAFF(9,"ROLE_BUSINESS_STAFF","商家子账号"),
    ROLE_BUSINESS_AGENT(10,"ROLE_BUSINESS_AGENT","商家代理"),
    ROLE_BUSINESS_NODE(11,"ROLE_BUSINESS_NODE","商家节点");

    private Integer id;
    private String value;
    private String desc;

    RoleEnum(Integer id, String value,String desc) {
        this.id = id;
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
