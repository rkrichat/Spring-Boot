package com.spring.bootjdbc.validator;

import com.spring.bootjdbc.bean.UserInfo;
import com.spring.bootjdbc.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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
        System.out.println("---------------->come here");
        UserInfo bean = (UserInfo) target;
        System.out.println("---------------->come here2");
        if (bean.getCode() == null) {
            errors.rejectValue("code","required.code");
        }else {
            try {
                String validate = userDao.getUserDetail(bean.getCode());
                System.out.println(validate);
                if(validate!=null){
                    errors.rejectValue("code","code.already.exist");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (bean.getName() == null) {
            errors.rejectValue("name", "required.name");
        }
    }

    public void show() {
        System.out.println("---->SHOW");
    }
}
