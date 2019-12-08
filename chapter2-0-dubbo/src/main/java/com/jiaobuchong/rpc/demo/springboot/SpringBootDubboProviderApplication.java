package com.jiaobuchong.rpc.demo.springboot;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jiaobuchong.rpc.demo.impl")
// 方式一
// 这个包的指定可以在application.yml配置文件里指定，也可以在这里通过 @EnableDubbo 注解指定
@EnableDubbo(scanBasePackages = "com.jiaobuchong.rpc.demo.impl")
public class SpringBootDubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDubboProviderApplication.class, args);
	}

	//@Bean
/*	public ServletRegistrationBean<DispatcherServlet> getServletRegistrationBean() {

		ServletRegistrationBean<DispatcherServlet> bean = new ServletRegistrationBean<DispatcherServlet>(
				new DispatcherServlet());
		bean.addUrlMappings("/*");
		bean.setLoadOnStartup(1);

		return bean;
	}*/

}
