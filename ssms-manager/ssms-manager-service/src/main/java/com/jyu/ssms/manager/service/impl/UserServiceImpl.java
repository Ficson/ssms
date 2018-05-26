package com.jyu.ssms.manager.service.impl;

import com.jyu.ssms.common.exception.SsmsException;
import com.jyu.ssms.manager.mapper.UserMapper;
import com.jyu.ssms.manager.pojo.User;
import com.jyu.ssms.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service("UserService")
public class UserServiceImpl implements UserService {

    /**
     * 注入UserMapper接口
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据电话查找用户
     */
    @Override
    public User findUserByPhone(String phone){
        return userMapper.findUserByPhone(phone);
    }



    /**
     * 新增用户(注册)
     */
    @Override
    public User insertUser(User user) {

        if(userMapper.findUserByPhone(user.getPhone())!=null){
            throw new SsmsException("该手机已经被注册");
        }
        //TODO
        user.setStatus(1);
        user.setCreatetime(new Date());
        user.setUpdatetime(new Date());
        String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Pass);
        user.setBalance(0);

        if(userMapper.insertUser(user)!=1){
            throw new SsmsException("添加用户失败");
        }
        return findUserByPhone(user.getPhone());

    }

    @Override
    public User login(User user){
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);
        User loginUser = userMapper.findUserByPhoneAndPwd(user);
        if(loginUser == null){
            throw new SsmsException("用户名或密码错误");
        }

        return loginUser;
    }

    /**
     * 更新用户(selective)
     */
    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }


    /**
     * 根据Id删除用户
     */
    @Override
    public int deleteUserById(Integer id) {
        if(userMapper.deleteUserById(id)!=1){
            throw new SsmsException("删除用户失败");
        }
        return 0;

    }

    /**
     * 根据id查找用户
     */
    @Override
    public User findUserById(int id) {
        User user = userMapper.findUserById(id);
        return user;
    }
    /**
     * 更新用户
     * */
    @Override
    public User updateUserById(int id, User user){

        //用户可能只修改了一部分
        User oldUser = findUserById(id);
        user.setId(id);

        user.setApikey(oldUser.getApikey());
        user.setStatus(oldUser.getStatus());
        user.setBalance(oldUser.getBalance());


        user.setCreatetime(oldUser.getCreatetime());
        user.setUpdatetime(new Date());

        if(user.getPhone()==null||user.getPhone()==""){
            user.setPhone(oldUser.getPhone());
        }

        if(user.getPassword()==null||user.getPassword()==""){
            user.setPassword(oldUser.getPassword());
        }else{
            String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(md5Pass);
        }
        if(userMapper.updateUserById(user)!=1){
            throw new SsmsException("更新用户信息失败");

        }
        return findUserById(id);

    }

    /**
     * 查询所有用户
     */
    /*@Override
    public List<User> findAll() {
        List<User> allUser = userMapper.findAll();
        return allUser;
    }*/
}
