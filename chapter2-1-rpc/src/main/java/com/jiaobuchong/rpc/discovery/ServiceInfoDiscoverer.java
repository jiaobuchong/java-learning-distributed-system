package com.jiaobuchong.rpc.discovery;

import java.util.List;

/**
 * 服务发现
 */
public interface ServiceInfoDiscoverer {
	List<ServiceInfo> getServiceInfo(String name);
}
