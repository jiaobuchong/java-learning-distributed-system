package com.study.springboot.springbootdemo.controller;

import com.jiaobuchong.tennis.TennisDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @Autowired
    private TennisDemo tennisDemo;

    @GetMapping("/index")
    public Object index(){
        return tennisDemo;
    }
}
