package com.jiaobuchong.rpc.demo.consumer;

import com.jiaobuchong.rpc.demo.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

@RestController
public class AnnotationDemoAction {

	@Reference(loadbalance = "roundrobin")
	private DemoService demoService;

	@RequestMapping("/hello")
	public String doSayHello(String name) {
		return demoService.sayHello(name);
	}
}
