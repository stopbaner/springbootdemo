package com.shenzp.springbootdemo.springboottest.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventNotifier implements ApplicationListener {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof MyEvent){
            MyEvent myEvent=(MyEvent)event;
            logger.info("MyEvent address:{}",myEvent.getAddress());
            logger.info("MyEvent age:{}",myEvent.getAge());
        }
    }
}
