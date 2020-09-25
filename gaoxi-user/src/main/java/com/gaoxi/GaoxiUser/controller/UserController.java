package com.gaoxi.GaoxiUser.controller;

import com.gaoxi.GaoxiUser.config.R;
import com.gaoxi.GaoxiUser.domain.User;
import com.gaoxi.GaoxiUser.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserController
 * @Author luyingshan 卢
 * @Date 2020/9/24
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper mapper;

    @GetMapping("/list")
    @ResponseBody
    public R getAllUser(){
        List<User> users = mapper.selectAll();
        if (users.size()>0 && users!=null){
            return new R(200,"success",users);
        }
         return new R(400,"error",null);
    }
}
