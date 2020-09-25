package com.gaoxi.GaoxiUser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @ClassName WebConfig
 * @Author luyingshan 卢
 * @Date 2020/9/24
 * @Version 1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    //@Autowired
    //LogInterceptor logInterceptor;

    @Autowired
    LoginInterceptor loginInterceptor;


    /*不需要登录拦截的url:登录注册和验证码 */

    final String[] notLoginInterceptPaths = {"/signin","/login/submitLogin","/reg/submitRegister","/login/","/index/","/register/","/kaptcha.jpg/","/kaptcha/"};//"/", "/login/", "/person/", "/register/", "/validcode", "/captchaCheck", "/file/", "/contract/htmltopdf", "/questions/", "/payLog/", "/error/" };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 日志拦截器
        //registry.addInterceptor(logInterceptor).addPathPatterns("/");
        // 登录拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").
                excludePathPatterns(notLoginInterceptPaths).
                excludePathPatterns("/login/submitLogin").
                excludePathPatterns("/static/**").
                excludePathPatterns("/layui/**");
    }

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}
