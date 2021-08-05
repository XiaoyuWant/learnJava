package com.xyw.service.impl;

import com.xyw.dao.impl.UserDao;
import com.xyw.dao.impl.UserDaoImpl;
import com.xyw.pojo.User;
import com.xyw.service.UserService;

public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();


    @java.lang.Override
    public void registerUser(User user) {
        userDao.saveUser(user);

    }

    @java.lang.Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());

    }

    @java.lang.Override
    public boolean existUsername(String username) {
        if(userDao.queryByUsername(username)==null){
            return true;
        }
        return false;
    }
}