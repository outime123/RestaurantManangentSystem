package com.example.RestaurantManagentSystem.controller;

import com.example.RestaurantManagentSystem.dao.HoaDonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.Assertions.assertThat;
@WebMvcTest
class DTTTControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    HoaDonRepository hoaDonRepository;
    @Test
    void index() throws Exception {
        MvcResult result = mockMvc.perform(get("/gdTKDoanhThuTheoThang")).andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    void testIndex() throws Exception {
        MvcResult result = mockMvc.perform(get("/")).andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    void getAllDT() {
    }

    @Test
    void getDTT() {
    }

}