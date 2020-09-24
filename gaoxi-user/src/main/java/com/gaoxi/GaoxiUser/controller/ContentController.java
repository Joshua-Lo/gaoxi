package com.gaoxi.GaoxiUser.controller;

import com.gaoxi.GaoxiUser.config.R;
import com.gaoxi.GaoxiUser.domain.Article;
import com.gaoxi.GaoxiUser.mapper.ArticleMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ContentController
 * @Author luyingshan 卢
 * @Date 2020/9/24
 * @Version 1.0
 */
@Controller
@RequestMapping("/article")
public class ContentController {
    @Resource
    private ArticleMapper articleMapper;
    @GetMapping("/list")
    public void getArticleList(){
        List<Article> articles = articleMapper.selectAll();

    }
}
