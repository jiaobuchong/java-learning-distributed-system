package com.jiaobuchong.rpc.demo.provider;


import com.jiaobuchong.rpc.common.protocol.JavaSerializeMessageProtocol;
import com.jiaobuchong.rpc.demo.DemoService;
import com.jiaobuchong.rpc.server.NettyRpcServer;
import com.jiaobuchong.rpc.server.RequestHandler;
import com.jiaobuchong.rpc.server.RpcServer;
import com.jiaobuchong.rpc.server.register.ServiceObject;
import com.jiaobuchong.rpc.server.register.ServiceRegister;
import com.jiaobuchong.rpc.server.register.ZookeeperExportServiceRegister;
import com.jiaobuchong.rpc.util.PropertiesUtils;

/**
 * 服务提供者
 */
public class Provider {
	public static void main(String[] args) throws Exception {

		int port = Integer.parseInt(PropertiesUtils.getProperties("rpc.port"));
		String protocol = PropertiesUtils.getProperties("rpc.protocol");

		// 服务注册
		ServiceRegister sr = new ZookeeperExportServiceRegister();
		DemoService ds = new DemoServiceImpl();
		ServiceObject so = new ServiceObject(DemoService.class.getName(), DemoService.class, ds);
		sr.register(so, protocol, port);

		RequestHandler reqHandler = new RequestHandler(new JavaSerializeMessageProtocol(), sr);

		RpcServer server = new NettyRpcServer(port, protocol, reqHandler);
		server.start();
		System.in.read(); // 按任意键退出
		server.stop();
	}
}
