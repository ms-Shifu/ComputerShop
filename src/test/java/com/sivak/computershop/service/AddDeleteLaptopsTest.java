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
@TestPropertySource("/application-test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Sql(value = {"/create-user-before.sql", "/create-laptop-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-laptop-after.sql", "/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@WithUserDetails("sam")
public class AddDeleteLaptopsTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private IndexController indexController;
    
    @Test
    public void addNewLaptopTest() throws Exception {
        
        MockHttpServletRequestBuilder mulipartParam = multipart("/laptopsEditAdd")
                .file("file", "123".getBytes())
                .param("manufacturer", "Xiaomi")
                .param("model", "RedmiBook 14")
                .param("monitor", "14")
                .param("cpu", "Inter Core i3")
                .param("ram", "8")
                .param("storageType", "HDD")
                .param("storageSize", "1000")
                .param("videoCard", "NVIDIA")
                .param("price", "699")
                .with(csrf());
        
        this.mockMvc.perform(mulipartParam)
                .andDo(print())
                .andExpect(authenticated());
        
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(xpath("//*[@id='laptops-list']/div[@data-id=1]").exists())
                .andExpect(xpath("//*[@id='laptops-list']/div[@data-id=10]").exists())
                .andExpect(xpath("//div[@id='laptops-list']/div").nodeCount(2));
    }
    
    @Test
    public void deleteLaptopTest() throws Exception {
    
        MockHttpServletRequestBuilder mulipartParam = post("/laptopsEditAdd")
                .param("manufacturer", "Xiaomi")
                .param("model", "RedmiBook 14")
                .param("monitor", "14")
                .param("cpu", "Inter Core i3")
                .param("ram", "8")
                .param("storageType", "HDD")
                .param("storageSize", "1000")
                .param("videoCard", "NVIDIA")
                .param("price", "699")
                .param("buttonEdit", "delete")
                .param("id", "10")
                .with(csrf());
        

        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(xpath("//*[@id='laptops-list']/div[@data-id=1]").exists())
                .andExpect(xpath("//div[@id='laptops-list']/div").nodeCount(1));
    }
}
