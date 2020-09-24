package com.gaoxi.GaoxiUser.controller;

import com.gaoxi.GaoxiUser.config.R;
import com.gaoxi.GaoxiUser.domain.User;
import com.gaoxi.GaoxiUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RegisterController
 * @Author luyingshan 卢
 * @Date 2020/9/23
 * @Version 1.0
 */
@Controller
@RequestMapping("/reg")
public class RegisterController {
    @Resource
    private UserService userservice;


    @RequestMapping()
    public String regis(){
        return "register";
    }

    @ResponseBody
    @PostMapping("/submitRegister")
    public R register(@RequestBody User user, HttpServletRequest request){
        String username = user.getUsername();
        System.out.println(username);
        R r = userservice.checkRepeat(user);
        if (r.getMsg().equals("OK")){
            R insert = userservice.insert(user);
            return insert;
        }else {
            return r;
        }
    }

}
