package com.jiaobuchong.rpc.client.net;


import com.jiaobuchong.rpc.discovery.ServiceInfo;

public interface NetClient {
	byte[] sendRequest(byte[] data, ServiceInfo sinfo) throws Throwable;
}
