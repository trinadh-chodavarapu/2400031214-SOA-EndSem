package com.klu.springmvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.klu.springmvc.service.UserService;

@WebMvcTest(MS1Controller.class)
public class MS1ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService us;

    // RIGHT CASE
    @Test
    void testAddRightCase() throws Exception {

        mockMvc.perform(
                get("/ms1/add")
                    .param("a", "5")
                    .param("b", "10")
        )
        .andExpect(status().isOk())
        .andExpect(content().string("MS1.1 addition15"));
    }
}