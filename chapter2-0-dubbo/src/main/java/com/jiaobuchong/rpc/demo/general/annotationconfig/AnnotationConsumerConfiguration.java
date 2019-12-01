package com.jiaobuchong.rpc.demo.general.annotationconfig;

import com.jiaobuchong.rpc.demo.consumer.AnnotationDemoAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

//@Configuration
// 让dubbo的注解生效
@EnableDubbo(scanBasePackages = "com.jiaobuchong.rpc.demo.consumer")
@PropertySource("classpath:/dubbo/dubbo-consumer.properties")
// 让 spring 的注解生效
@ComponentScan(value = { "com.jiaobuchong.rpc.demo.consumer" })
public class AnnotationConsumerConfiguration {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AnnotationConsumerConfiguration.class);
		context.start();
		final AnnotationDemoAction annotationAction = context.getBean(AnnotationDemoAction.class);
		String hello = annotationAction.doSayHello("world");
		System.out.println(hello);
		context.close();
	}
}
