package com.gaoxi.GaoxiUser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName UrlController
 * @Author luyingshan 卢
 * @Date 2020/9/24
 * @Version 1.0
 */
@Controller
public class UrlController {

    @RequestMapping("/index")
    public String get(){
        return  "index";
    }

    @RequestMapping("/page/{url}")
    public String  url(@PathVariable String url){
        return url;
    }
}
