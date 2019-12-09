package com.niocoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
@RestController
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)// 排除数据库链接，测试SpringBoot
@SpringBootApplication
@MapperScan(basePackages = "com.niocoder.mapper")
public class APIApplication {

    public static void main(String[] args) {
        SpringApplication.run(APIApplication.class, args);
    }

    @GetMapping("hello")
    public String hello() {
        return "hello SpringBoot!";
    }
}
