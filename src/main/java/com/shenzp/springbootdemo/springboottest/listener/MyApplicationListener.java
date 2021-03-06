package com.shenzp.springbootdemo.springboottest.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * description:自定义监听器
 */
@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("执行MyApplicationListener");
        if(event instanceof ContextRefreshedEvent){
            logger.info("ContextRefreshedEvent:{}",event);
        }
    }
}
