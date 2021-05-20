package com.xyw.test;

import com.xyw.pojo.User;
import com.xyw.service.UserService;
import com.xyw.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser(){
        userService.registerUser(new User(1,"","",""));

    }

    @Test
    public void login(){
        if(userService.existUsername("name")){
            System.out.println("exist");
        }
        System.out.println("not exist");

    }
}
