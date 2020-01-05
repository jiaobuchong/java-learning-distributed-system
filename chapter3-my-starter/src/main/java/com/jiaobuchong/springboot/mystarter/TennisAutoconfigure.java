package com.jiaobuchong.springboot.mystarter;

import com.jiaobuchong.tennis.TennisDemo;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 定义 spring-boot starter
// https://www.cnblogs.com/hello-shf/p/10864977.html
@Configuration
@EnableConfigurationProperties(TennisProperties.class)
public class TennisAutoconfigure {

    @Bean
    public TennisDemo getTennis(TennisProperties tennisProperties) {
        TennisDemo tennisDemo = new TennisDemo();
        tennisDemo.setColor(tennisProperties.getColor());
        tennisDemo.setPrice(tennisProperties.getPrice());
        tennisDemo.setWeight(tennisProperties.getWeight());
        return tennisDemo;
    }
}
