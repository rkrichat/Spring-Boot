package com.spring.bootjdbc.user.service.impl;

import com.spring.bootjdbc.bean.UserInfo;
import com.spring.bootjdbc.user.dao.UserDao;
import com.spring.bootjdbc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public String getUserDetail(String id){
        try {
            return userDao.getUserDetail(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserInfo createUser(UserInfo bean) {
        try {
            return userDao.createUser(bean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteUser(UserInfo bean) {
        try {
            return userDao.deleteUser(bean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
