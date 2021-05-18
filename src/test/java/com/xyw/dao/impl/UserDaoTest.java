package com.xyw.dao.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void queryByUsername() {
        UserDao userDao=new UserDaoImpl();
        System.out.println(userDao.queryByUsername("admin"));
    }

    @Test
    void queryUserByUsernameAndPassword() {
    }

    @Test
    void saveUser() {
    }
}