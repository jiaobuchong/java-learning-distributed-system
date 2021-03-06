package com.jiaobuchong.springboot.demo;

import com.jiaobuchong.springboot.demo.properties.MyPropertiesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
    // 冒号后面，就是一个默认值
    @Value("${names:default-tony}")
    public String name;

    @Autowired
    MyPropertiesBean myPropertiesBean;

    // 应用已启动就会执行
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("启动完毕，读取到配置：" + name);
        System.out.println("启动完毕，读取到myPropertiesBean配置：" + myPropertiesBean.getUserName());
    }
}
