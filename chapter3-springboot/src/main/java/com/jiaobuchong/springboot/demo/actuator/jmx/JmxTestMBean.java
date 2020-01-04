package com.jiaobuchong.springboot.demo.actuator.jmx;

public interface JmxTestMBean {
    public String getName();
    public void setName(String name);
    public String printHello();
    public String printHello(String whoName);
}