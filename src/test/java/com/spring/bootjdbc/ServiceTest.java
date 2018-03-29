package com.spring.bootjdbc;

import com.google.gson.Gson;
import com.spring.bootjdbc.bean.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSearch_exist_mustFound() throws Exception {
        mockMvc.perform(get("/user?id=user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("KRIT"));
    }

    @Test
    public void testSearch_noExist_musNotFound() throws Exception {
        mockMvc.perform(get("/user?id=notfound"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").doesNotExist());
    }
}
