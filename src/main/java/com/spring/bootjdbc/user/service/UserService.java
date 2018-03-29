package com.spring.bootjdbc.user.service;

import com.spring.bootjdbc.bean.UserInfo;

public interface UserService {
     String getUserDetail(String id);

     UserInfo createUser(UserInfo bean);

     String deleteUser(UserInfo bean);
}