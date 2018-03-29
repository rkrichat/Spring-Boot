package com.spring.bootjdbc;

import com.spring.bootjdbc.bean.UserInfo;
import com.spring.bootjdbc.validator.RegisterValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterTest {

    @Autowired
    private RegisterValidator validator;

    @Test
    public void createUser_exist_mustError() {
        UserInfo data = new UserInfo("user", "earl");
        data.setName("");
        Errors errors = new BeanPropertyBindingResult(data, "userInfo");
        validator.validate(data, errors);
        assertTrue(errors.hasErrors());
    }

    @Test
    public void createUser_noExist_mustPass() {
        UserInfo data = new UserInfo("user2","earl");
        Errors errors = new BeanPropertyBindingResult(data, "userInfo");
        validator.validate(data, errors);
        assertFalse(errors.hasErrors());
    }
}
