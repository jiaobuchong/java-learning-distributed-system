package com.jiaobuchong.rpc.demo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jiaobuchong.rpc.demo.DemoService;

@Service
public class DemoServiceImpl implements DemoService {
	public String sayHello(String name) {
		System.out.println("*********************** " + name);
		return "Hello " + name;
	}
}
