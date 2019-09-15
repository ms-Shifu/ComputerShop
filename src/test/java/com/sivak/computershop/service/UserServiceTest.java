package com.sivak.computershop.service;

import com.sivak.computershop.entities.Roles;
import com.sivak.computershop.entities.Users;
import com.sivak.computershop.repos.UserRepo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class UserServiceTest {
    
    @Autowired
    private UserService userService;
    
    @MockBean
    private UserRepo userRepo;
    
    @MockBean
    private MailService mailService;
    
    @Test
    public void addNewUserTest() {
        Users user = new Users();
        user.setEmail("some@mail.com");
        
        boolean isAddNewUser = userService.addNewUser(user);
    
        Assert.assertTrue(isAddNewUser);
        Assert.assertNotNull(user.getActivationCode());
        Assert.assertTrue(CoreMatchers.is(user.getRoles())
                .matches(Collections.singleton(Roles.USER)));
    
        Mockito.verify(userRepo, Mockito.times(1)).save(user);
        Mockito.verify(mailService, Mockito.times(1))
                .send(
                        ArgumentMatchers.eq(user.getEmail()),
                        ArgumentMatchers.eq("Activating account"),
                        ArgumentMatchers.anyString()
                );
    }
    
    @Test
    public void addNewUserFailTest() {
        Users user = new Users();
        user.setUsername("AnyUser");
        
        Mockito.doReturn(new Users())
                .when(userRepo)
                .findByUsername("AnyUser");
    
        boolean isAddNewUser = userService.addNewUser(user);
    
        Assert.assertFalse(isAddNewUser);
    
        Mockito.verify(userRepo, Mockito.times(0))
                .save(ArgumentMatchers.any(Users.class));
        Mockito.verify(mailService, Mockito.times(0)).send(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString()
        );
        
    }
    
    
    @Test
    public void activateTest() {
    
        Users user = new Users();
        user.setActivationCode("SomeCode");
    
        Mockito.doReturn(user)
                .when(userRepo)
                .findByActivationCode("activate");
        
        boolean isActivatedUser = userService.activate("activate");
    
        Assert.assertTrue(isActivatedUser);
    
        Mockito.verify(userRepo, Mockito.times(1)).save(user);
    }
    
    @Test
    public void activateFailTest() {
    
        boolean isActivatedUser = userService.activate("activate2");
    
        Assert.assertFalse(isActivatedUser);
    
        Mockito.verify(userRepo, Mockito.times(0))
                .save(ArgumentMatchers.any(Users.class));
    }
    
    @Test
    public void passwordRecoverySendTest() {
        Users user = new Users();
        user.setEmail("some@mail.com");
    
        Mockito.doReturn(user)
                .when(userRepo)
                .findByEmail("some@mail.com");
    
        boolean isPasswordRecoverySend = userService.passwordRecoverySend("some@mail.com");
        
        Assert.assertTrue(isPasswordRecoverySend);
        
        Mockito.verify(mailService, Mockito.times(1)).send(
                ArgumentMatchers.eq(user.getEmail()),
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString()
        );
    }
    
    @Test
    public void passwordRecoverySendFailTest() {
        boolean isPasswordRecoverySend = userService.passwordRecoverySend("some@mail.com");
    
        Assert.assertFalse(isPasswordRecoverySend);
    
        Mockito.verify(mailService, Mockito.times(0)).send(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString()
        );
    }
}