package com.jiaobuchong.springboot.demo.actuator.jmx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestJMXRegListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    JmxTest jmxTest;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            // create mbean server
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            // create object name
            ObjectName objectName = null;
            objectName = new ObjectName("jmxBean:name=testJM1X");
            // 注册
            server.registerMBean(jmxTest, objectName);
            // 注册一个端口，绑定url后，客户端就可以使用rmi通过url方式来连接JMXConnectorServer
            Registry registry = LocateRegistry.createRegistry(1099);
            // 构造JMXServiceURL
            JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
            // 创建 JMXConnectorServer
            JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(jmxServiceURL, null, server);
            // 启动
            cs.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
