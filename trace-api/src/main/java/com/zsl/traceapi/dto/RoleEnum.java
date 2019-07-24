package com.zsl.traceapi.dto;

public enum  RoleEnum {
    ROLE_SYSTEM_ADMIN("ROLE_SYSTEM_ADMIN"),
    ROLE_HEADQUARTERS_ADMIN("ROLE_HEADQUARTERS_ADMIN"),
    ROLE_HEADQUARTERS_OPERATE("ROLE_HEADQUARTERS_OPERATE"),
    ROLE_HEADQUARTERS_FINANCE("ROLE_HEADQUARTERS_FINANCE"),
    ROLE_FRANCHISEE_ADMIN("ROLE_FRANCHISEE_ADMIN"),
    ROLE_FRANCHISEE_OPERATE("ROLE_FRANCHISEE_OPERATE"),
    ROLE_FRANCHISEE_FINANCE("ROLE_FRANCHISEE_FINANCE"),
    ROLE_BUSINESS("ROLE_BUSINESS");

    private String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
