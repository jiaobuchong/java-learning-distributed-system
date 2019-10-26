package com.jiaobuchong.rpc.demo.consumer;

import com.jiaobuchong.rpc.client.ClientStubProxyFactory;
import com.jiaobuchong.rpc.client.net.NettyNetClient;
import com.jiaobuchong.rpc.common.protocol.JavaSerializeMessageProtocol;
import com.jiaobuchong.rpc.common.protocol.MessageProtocol;
import com.jiaobuchong.rpc.demo.DemoService;
import com.jiaobuchong.rpc.discovery.ZookeeperServiceInfoDiscoverer;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


public class Consumer {
	public static void main(String[] args) throws Exception {

		ClientStubProxyFactory cspf = new ClientStubProxyFactory();
		// 设置服务发现者
		cspf.setSid(new ZookeeperServiceInfoDiscoverer());

		// 设置支持的协议
		Map<String, MessageProtocol> supportMessageProtocols = new HashMap<>();
		supportMessageProtocols.put("javas", new JavaSerializeMessageProtocol());
		cspf.setSupportMessageProtocols(supportMessageProtocols);

		// 设置网络层实现
		cspf.setNetClient(new NettyNetClient());

		DemoService demoService = cspf.getProxy(DemoService.class); // 获取远程服务代理
		String hello = demoService.sayHello("world"); // 执行远程方法
		System.out.println(hello); // 显示调用结果

		System.out.println(demoService.multiPoint(new Point(5, 10), 2));
	}
}
