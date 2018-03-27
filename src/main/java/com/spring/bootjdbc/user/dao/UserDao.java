package com.spring.bootjdbc.user.dao;

import com.spring.bootjdbc.bean.UserInfo;

import java.sql.SQLException;

public interface UserDao {
    public String getUserDetail(String id) throws SQLException;

    public String createUser(UserInfo bean) throws SQLException;
}
