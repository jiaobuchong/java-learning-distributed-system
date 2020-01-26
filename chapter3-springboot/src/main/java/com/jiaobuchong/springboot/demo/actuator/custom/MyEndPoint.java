package com.jiaobuchong.springboot.demo.actuator.custom;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

@Endpoint(id = "myEndpoint")
@Component
public class MyEndPoint {

    String name = "default";

    // 读取端点的操作
    @ReadOperation
    public String getName() {
        // spring http端点的json格式
        return "{\"name\":\""+name+"\"}";
    }

    // 删除端点的值
    @DeleteOperation
    public void delName() {
        name = "";
    }

    // 修改端点的值
    @WriteOperation
    public void setName(@Selector String name) {
        this.name = name;
    }

}

