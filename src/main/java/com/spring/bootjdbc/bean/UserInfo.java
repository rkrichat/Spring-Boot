package com.spring.bootjdbc.bean;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class UserInfo {
    @NotBlank
    private String code;

    @NotBlank(message = "name.is.required")
    @Length(min = 1,max = 50)
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
