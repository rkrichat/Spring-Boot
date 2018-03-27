package com.spring.bootjdbc.user.service;

import com.spring.bootjdbc.bean.UserInfo;

import java.sql.SQLException;

public interface UserService {
    public String getUserDetail(String id);

    public String createUser(UserInfo bean);
}