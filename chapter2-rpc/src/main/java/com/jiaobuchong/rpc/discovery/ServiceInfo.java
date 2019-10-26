package com.jiaobuchong.rpc.discovery;

public class ServiceInfo {

	// 服务名称
	private String name;

	// 消息协议
	private String protocol;

	// 服务端 ip 地址
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
