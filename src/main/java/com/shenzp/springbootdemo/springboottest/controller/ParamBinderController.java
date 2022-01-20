package com.shenzp.springbootdemo.springboottest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParamBinderController {

    @RequestMapping("/getMap")
    public Map getMap(){
        Map map=new HashMap();
        map.put("name","helen");
        map.put("age",15);
        return map;
    }
}
