package com.spring.bootjdbc.user.dao;

import com.spring.bootjdbc.bean.UserInfo;

import java.sql.SQLException;

public interface UserDao {
    String getUserDetail(String id) throws SQLException;

    String createUser(UserInfo bean) throws SQLException;
}
