package com.jiaobuchong.rpc.discovery;

import java.util.List;

public interface ServiceInfoDiscoverer {
	List<ServiceInfo> getServiceInfo(String name);
}
