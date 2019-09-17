package com.sivak.computershop.service;

import com.sivak.computershop.controllers.IndexController;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-dev.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IndexControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private IndexController indexController;
    
    @Test
    @WithUserDetails("u1")
    public void cartAuthTest() throws Exception {
        this.mockMvc.perform(get("/cart"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//div[@id='navbarSupportedContent']/div").string("u1"));
    }
    
    @Test
    public void laptopsListTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(xpath("//div[@id='laptops-list']/div").nodeCount(6));
    }
    
    @Test
    public void laptopsFilterManufacturerTest() throws Exception {
        this.mockMvc.perform(get("/").param("manufacturer", "Apple"))
                .andDo(print())
                .andExpect(xpath("//div[@id='laptops-list']/div").nodeCount(2));
    }
    
    @Test
    public void laptopsFilterScreenSizeTest() throws Exception {
        this.mockMvc.perform(get("/").param("monitor", "15"))
                .andDo(print())
                .andExpect(xpath("//div[@id='laptops-list']/div").nodeCount(4));
    }
    
    
}
