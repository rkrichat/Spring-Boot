package com.spring.bootjdbc.user;

import com.spring.bootjdbc.bean.UserInfo;
import com.spring.bootjdbc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserResource {
    @Autowired
    private UserService userService;

    @Autowired
    private Validator registerValidator;


    @InitBinder("userInfo")
    public void setupBinder(WebDataBinder binder) {
        binder.addValidators(registerValidator);
    }

    @GetMapping
    public UserInfo getUserDetail(@RequestParam String id) {
        String result = userService.getUserDetail(id);
        return new UserInfo(result);
    }

    @PutMapping
    public String createUser(@Valid @RequestBody UserInfo bean, BindingResult result) {
        registerValidator.validate(bean,result);
        System.out.println("---------------------------->"+result);
        if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }else{
            return  userService.createUser(bean);
        }
    }

    @DeleteMapping
    public String deleteUser(@RequestBody UserInfo bean) {
        return userService.deleteUser(bean);
    }
}
