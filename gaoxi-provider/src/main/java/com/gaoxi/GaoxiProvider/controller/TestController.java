package com.gaoxi.GaoxiProvider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Author luyingshan 卢
 * @Date 2020/9/22
 * @Version 1.0
 */
@RestController
public class TestController {
    @GetMapping(value = "test/{string}")
    public String testPrint(@PathVariable String string){
        return "This is a test:"+string;
    }
}
