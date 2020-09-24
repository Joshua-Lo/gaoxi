package com.gaoxi.GaoxiUser.controller;

import com.gaoxi.GaoxiUser.config.R;
import com.gaoxi.GaoxiUser.domain.User;
import com.gaoxi.GaoxiUser.service.UserService;
import com.gaoxi.GaoxiUser.vo.LoginParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginController
 * @Author luyingshan 卢
 * @Date 2020/9/23
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserService userservice;

    @RequestMapping
    public String login(){
        return "login";
    }

    @PostMapping("/submitLogin")
    @ResponseBody
    public R login(@RequestBody LoginParam param,HttpSession httpSession){
        User user = userservice.getUser(param);
        System.out.println(user.getUsername());
        if (user!=null){
            httpSession.setAttribute("user", user);
            return new R(200,"success",user);
        }
        return new R(400,"error", user);
    }

}
