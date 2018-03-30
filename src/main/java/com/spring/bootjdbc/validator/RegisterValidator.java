package com.spring.bootjdbc.validator;

import com.spring.bootjdbc.bean.UserInfo;
import com.spring.bootjdbc.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.sql.SQLException;

@Component
public class RegisterValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserInfo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserInfo bean = (UserInfo) target;
        try {
            if (userDao.getUserDetail(bean.getCode()) != null) {
                errors.reject("code", "code.already.exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
