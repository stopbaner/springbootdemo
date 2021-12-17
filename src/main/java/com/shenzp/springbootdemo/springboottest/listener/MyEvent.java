package com.shenzp.springbootdemo.springboottest.listener;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    private String address;

    private Integer age;

    public MyEvent(Object source,String address,Integer age) {
        super(source);
        this.address=address;
        this.age=age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
