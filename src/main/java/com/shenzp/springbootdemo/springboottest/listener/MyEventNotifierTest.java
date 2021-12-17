package com.shenzp.springbootdemo.springboottest.listener;


import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class MyEventNotifierTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext(MyEventNotifier.class);
        MyEvent myEvent=new MyEvent("source","上海市浦東新區",18);
        applicationContext.publishEvent(myEvent);
    }
}
