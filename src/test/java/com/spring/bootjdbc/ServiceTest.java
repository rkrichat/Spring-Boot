package com.spring.bootjdbc;

import com.google.gson.Gson;
import com.spring.bootjdbc.bean.UserInfo;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void stage1_testSearchUser_exist_mustFound() throws Exception {
        mockMvc.perform(get("/user?id=user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("KRIT"));
    }

    @Test
    public void stage2_testSearchUser_noExist_mustNotFound() throws Exception {
        mockMvc.perform(get("/user?id=notfound"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").doesNotExist());
    }

    @Test
    public void stage3_deleteUser_exit_mustPass() throws Exception {
        UserInfo data = new UserInfo("user2","kritchat");
        mockMvc.perform(delete("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(data)))
                .andExpect(status().isOk());
    }

    @Test
    public void stage4_testCreateUser_noExist_mustPass() throws Exception {
        UserInfo data = new UserInfo("user2","kritchat");
        mockMvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(data)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value("user2"));
    }

    @Test
    public void stage5_CreateUser_exist_mustError() throws Exception {
        UserInfo data = new UserInfo("user2","kritchat");
        mockMvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(data))).andExpect(status().is4xxClientError()).andDo(print());
    }

}
