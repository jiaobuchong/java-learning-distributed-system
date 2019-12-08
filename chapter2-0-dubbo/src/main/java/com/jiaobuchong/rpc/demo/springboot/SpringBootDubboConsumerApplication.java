package com.jiaobuchong.rpc.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;

//--spring.profiles.active=dev 通过这个访问 application-dev.yml 配置文件
// idea 配置 program arguments
@SpringBootApplication
@ComponentScan("com.jiaobuchong.rpc.demo.consumer")
@EnableDubbo(scanBasePackages = "com.jiaobuchong.rpc.demo.consumer")
public class SpringBootDubboConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDubboConsumerApplication.class, args);
	}

}
