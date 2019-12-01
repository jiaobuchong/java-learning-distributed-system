package com.jiaobuchong.rpc.demo.provider;

import com.jiaobuchong.rpc.demo.DemoService;

import java.awt.Point;


public class DemoServiceImpl implements DemoService {
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@Override
	public Point multiPoint(Point p, int multi) {
		p.x = p.x * multi;
		p.y = p.y * multi;
		return p;
	}
}
