package com.jyu.ssms.manager.service;

import com.jyu.ssms.manager.pojo.User;

public interface UserService {
    User insertUser(User user);

    int updateByPrimaryKeySelective(User user);

    int deleteUserById(Integer id);

    User findUserById(int id);

    User updateUserById(int id, User user);

    User findUserByPhone(String phone);

    User login(User user);
    // List<User> findAll();
}
