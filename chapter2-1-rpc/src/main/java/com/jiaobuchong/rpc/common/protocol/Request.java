package com.jiaobuchong.rpc.common.protocol;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5200571424236772650L;

	// 服务名称
	private String serviceName;

	// 调用方法名
	private String method;

	private Map<String, String> headers = new HashMap<String, String>();

	// 方法参数类型
	// 需要保证参数对象也是可以序列化的
	private Class<?>[] prameterTypes;

	// 方法参数值
	private Object[] parameters;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Class<?>[] getPrameterTypes() {
		return prameterTypes;
	}

	public void setPrameterTypes(Class<?>[] prameterTypes) {
		this.prameterTypes = prameterTypes;
	}

	public void setParameters(Object[] prameters) {
		this.parameters = prameters;
	}

	public String getHeader(String name) {
		return this.headers == null ? null : this.headers.get(name);
	}

	public Object[] getParameters() {
		return this.parameters;
	}

}
