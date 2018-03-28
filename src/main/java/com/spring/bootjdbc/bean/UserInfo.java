package com.spring.bootjdbc.bean;

public class UserInfo {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public UserInfo() {
    }

    public UserInfo(String name) {
        this.name = name;
    }

    public UserInfo(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
