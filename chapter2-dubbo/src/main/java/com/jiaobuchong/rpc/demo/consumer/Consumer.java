package com.jiaobuchong.rpc.demo.consumer;

import com.jiaobuchong.rpc.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Consumer {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		context.start();

		// client stub
		DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
		String hello = demoService.sayHello("world"); // 执行远程方法
		System.out.println(hello); // 显示调用结果

		System.out.println();
		System.out.println(demoService);
		context.close();
	}
}
