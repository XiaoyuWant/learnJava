package com.xyw.dao.impl;

import com.xyw.pojo.User;

public interface UserDao {

    public User queryByUsername(String username);

    public User queryUserByUsernameAndPassword(String username,String password);

    public int saveUser(User user);
}
