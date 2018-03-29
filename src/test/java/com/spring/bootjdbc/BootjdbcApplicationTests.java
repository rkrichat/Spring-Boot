package com.spring.bootjdbc;

import com.google.gson.Gson;
import com.spring.bootjdbc.bean.UserInfo;
import javafx.application.Application;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BootjdbcApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    private UserInfo data;

    @Before
    public void initialResourece() {
        data = new UserInfo();
        data.setCode("rkrit");
        data.setName("KRIT");
    }
//
//    @Test
//    public void createUser_exits_mustError() throws Exception {
//        Gson gson = new Gson();
//        String jsonData = gson.toJson(data);
//        MvcResult result = mockMvc.perform(put("/user").contentType(MediaType.APPLICATION_JSON)
//                .content(jsonData))
//                .andExpect(status().isOk())
//                .andReturn();
//                //.andDo(print());
//        Errors errors = new BeanPropertyBindingResult(result, "registerForm");
//        String content = result.getResponse().getContentAsString();
//        System.out.println(content);
//    }
//
//    @Test
//    public void get_user_detail() throws Exception {
//       MvcResult result =  mockMvc.perform(get("/user?id=rkrit"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("name").value("KRIT"))
//                .andReturn();
//        System.out.println(result.getResponse().getContentAsString());
//    }

}
