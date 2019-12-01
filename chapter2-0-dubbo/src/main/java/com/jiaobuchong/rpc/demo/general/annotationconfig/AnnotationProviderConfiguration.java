package com.jiaobuchong.rpc.demo.general.annotationconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

//@Configuration
// 启用 dubbo 的注解支持，扫描我们的服务 service
@EnableDubbo(scanBasePackages = "com.jiaobuchong.rpc.demo.impl")
@PropertySource("classpath:/dubbo/dubbo-provider.properties")
public class AnnotationProviderConfiguration {
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AnnotationProviderConfiguration.class);
		context.start();
		System.in.read(); // 按任意键退出
		context.close();
	}
}
