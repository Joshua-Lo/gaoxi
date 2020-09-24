package com.gaoxi.GaoxiUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@EnableScheduling
@Configuration
@SpringBootApplication
@MapperScan("com.gaoxi.GaoxiUser.mapper")
public class GaoxiUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaoxiUserApplication.class, args);
    }

}
