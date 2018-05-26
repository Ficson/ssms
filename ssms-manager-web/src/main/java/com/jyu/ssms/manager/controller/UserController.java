package com.jyu.ssms.manager.controller;

import com.jyu.ssms.common.pojo.Result;
import com.jyu.ssms.common.utils.ResultUtil;
import com.jyu.ssms.manager.pojo.User;
import com.jyu.ssms.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //到注册界面
    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
    @ResponseBody
    public String toRegister() {

        // TODO
        return "/redirect:/user/register";

    }

    //注册用户
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result<User> register(@ModelAttribute User user){
        User newUser = userService.insertUser(user);
        return new ResultUtil<User>().setData(newUser);
    }


    //到用户登录界面
    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    @ResponseBody
    public String toLogin(){
        //TODO
        return "/redirect:/user/login";

    }

    //用户登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result<User> login (@ModelAttribute User user){
        User loginUser = userService.login(user);

        return new ResultUtil<User>().setData(user);

    }


    //按照id查询用户信息
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result<User> findUserById(@PathVariable Integer id){

        User user = userService.findUserById(id);
        return new ResultUtil<User>().setData(user);
    }

    //根据id删除用户
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<User> deleteUserById(@PathVariable("id") Integer id)
    {
        userService.deleteUserById(id);
        return new ResultUtil<User>().setData(null);
    }



    //修改用户信息
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @ResponseBody
    public Result<User> update(@PathVariable Integer id,@ModelAttribute User user){

        User newUser = userService.updateUserById(id, user);
        return new ResultUtil<User>().setData(newUser);
    }

}
