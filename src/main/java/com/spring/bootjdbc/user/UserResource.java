package com.spring.bootjdbc.user;

import com.spring.bootjdbc.bean.UserInfo;
import com.spring.bootjdbc.user.service.UserService;
import com.spring.bootjdbc.validator.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserResource {
    @Autowired
    private UserService userService;

    @Autowired
    private RegisterValidator registerValidator;

    @GetMapping
    public ResponseEntity getUserDetail(@RequestParam String id) {
        String result = userService.getUserDetail(id);
        return new ResponseEntity<Object>(new UserInfo(result), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity createUser(@Valid @RequestBody UserInfo bean, BindingResult result) {
        registerValidator.validate(bean,result);
        if (result.hasErrors()) {
            return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<Object>(userService.createUser(bean), HttpStatus.OK);
        }
    }

    @DeleteMapping
    public String deleteUser(@RequestBody UserInfo bean) {
        return userService.deleteUser(bean);
    }
}
