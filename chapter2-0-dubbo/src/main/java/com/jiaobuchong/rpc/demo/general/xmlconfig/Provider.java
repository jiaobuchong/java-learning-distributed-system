package com.jiaobuchong.rpc.demo.general.xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// 使用 xml 配置版本
public class Provider {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
		context.start();
		System.in.read(); // 按任意键退出
	}
}
