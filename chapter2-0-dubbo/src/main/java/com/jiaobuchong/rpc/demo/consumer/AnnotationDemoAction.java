package com.jiaobuchong.rpc.demo.consumer;

import com.jiaobuchong.rpc.demo.DemoService;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

@RestController
public class AnnotationDemoAction {

	@Reference
	private DemoService demoService;

	public String doSayHello(String name) {
		return demoService.sayHello(name);
	}
}
