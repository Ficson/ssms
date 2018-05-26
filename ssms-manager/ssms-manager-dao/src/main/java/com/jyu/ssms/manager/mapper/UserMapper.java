package com.jyu.ssms.manager.mapper;

import com.jyu.ssms.manager.pojo.User;
import org.springframework.stereotype.Service;

public interface UserMapper {
    int deleteUserById(Integer id);

    int insertUser(User record);

    int insertSelective(User record);

    User findUserById(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateUserById(User record);

    User findUserByPhone(String phone);


    User findUserByPhoneAndPwd(User user);



}