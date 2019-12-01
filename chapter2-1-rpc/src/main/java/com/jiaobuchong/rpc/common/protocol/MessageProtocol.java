package com.jiaobuchong.rpc.common.protocol;

public interface MessageProtocol {

	// 对请求参数的编组和解组
	byte[] marshallingRequest(Request req) throws Exception;

	Request unmarshallingRequest(byte[] data) throws Exception;

	// 对响应参数的编组和解组
	byte[] marshallingResponse(Response rsp) throws Exception;

	Response unmarshallingResponse(byte[] data) throws Exception;
}
