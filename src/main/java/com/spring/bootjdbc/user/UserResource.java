package com.spring.bootjdbc.user;

import com.spring.bootjdbc.bean.UserInfo;
import com.spring.bootjdbc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public UserInfo getUserDetail(@RequestParam String id) {
        String result = userService.getUserDetail(id);
        return new UserInfo(result);
    }

    @PutMapping
    public String createUser(@RequestBody UserInfo bean) {
        return userService.createUser(bean);
    }

    @DeleteMapping
    public String deleteUser(@RequestBody UserInfo bean) {
        return userService.deleteUser(bean);
    }
}
