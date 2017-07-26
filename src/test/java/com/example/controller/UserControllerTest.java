package com.example.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by daile on 2017/6/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    /*测试流程
    * 1.准备测试环境
    * 2.通过MovkMvc执行请求
    * 3.1 添加验证断言
    * 3.2 添加结果处理器
    * 3.3 得到MVCResult进行自定义断言/进行下一步的异步请求
    * 4. 卸载测试环境
    *
    * */
    private MockMvc mvc;
    RequestBuilder request = null;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(
                new UserController()
        ).build();
    }

    @Test
    public void listUser() throws Exception {

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"neeson\",\"age\":22}]")));
    }

    @Test
    public void saveUser() throws Exception {
        request = post("/users/")
                .param("id", "1")
                .param("name", "neeson")
                .param("age", "22");
        mvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string(equalTo("success")));

    }

    @Test
    public void getUser() throws Exception {
        request = get("/users/1");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"neeson\",\"age\":22}")));
    }

    @Test
    public void updateUser() throws Exception {
        request = put("/users/1")
                .param("name","neeson")
                .param("age","22");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));
    }

    @Test
    public void deleteUser() throws Exception {
        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

    }

   /* @Test
    public void testUserController() throws Exception {
//  	测试UserController
        RequestBuilder request = null;

        // 1、get查一下user列表，应该为空
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 2、post提交一个user
        request = post("/users/")
                .param("id", "1")
                .param("name", "测试大师")
                .param("age", "20");
        mvc.perform(request)
//				.andDo(MockMvcResultHandlers.print())
                .andExpect(content().string(equalTo("success")));

        // 3、get获取user列表，应该有刚才插入的数据
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

        // 4、put修改id为1的user
        request = put("/users/1")
                .param("name", "测试终极大师")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 5、get一个id为1的user
        request = get("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

        // 6、del删除id为1的user
        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 7、get查一下user列表，应该为空
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }*/

}