package com.beta.replyservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ReplyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReplyController replyController;


    /**  Tests cases for valid inputs  **/

    @Test
    public void replyControlTest1WithValidInput() throws Exception {
        mockMvc.perform(get("/reply/11-kbzw9ru"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", is("kbzw9ru")));
    }

    @Test
    public void replyControlTest2WithValidInput() throws Exception {
        mockMvc.perform(get("/reply/12-kbzw9ru"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", is("5a8973b3b1fafaeaadf10e195c6e1dd4")));
    }

    @Test
    public void replyControlTest3WithValidInput() throws Exception {
        mockMvc.perform(get("/reply/21-kbzw9ru"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", is("daf168567f92b1c464459087eaaefaf0")));
    }

    @Test
    public void replyControlTest4WithValidInput() throws Exception {
        mockMvc.perform(get("/reply/22-kbzw9ru"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", is("e8501e64cf0a9fa45e3c25aa9e77ffd5")));
    }

    /**  Tests cases for invalid inputs  **/

    @Test
    public void replyControlTest1WithInValidInput() throws Exception {
        mockMvc.perform(get("/reply/122-kbzw9ru"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("message", is("Invalid input")));
    }

    @Test
    public void replyControlTest2WithInValidInput() throws Exception {
        mockMvc.perform(get("/reply/13-kbzw9ru"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("message", is("Invalid input")));
    }

    @Test
    public void replyControlTest3WithInValidInput() throws Exception {
        mockMvc.perform(get("/reply/12--kbzw9ru"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("message", is("Invalid input")));
    }

    @Test
    public void replyControlTest4WithInValidInput() throws Exception {
        mockMvc.perform(get("/reply/1-kbzw9ru"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("message", is("Invalid input")));
    }

    @Test
    public void replyControlTest5WithInValidInput() throws Exception {
        mockMvc.perform(get("/reply/-kbzw9ru"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("message", is("Invalid input")));
    }
}
