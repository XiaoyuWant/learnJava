package com.xyw.service;

import com.xyw.pojo.User;

public interface UserService{
    public void registerUser(User user);
    public User login(User user);
    public boolean existUsername(String username);

}