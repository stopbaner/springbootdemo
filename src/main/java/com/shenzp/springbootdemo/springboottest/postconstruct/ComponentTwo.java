package com.shenzp.springbootdemo.springboottest.postconstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ComponentTwo {

    public ComponentTwo(){
        logger.info("ComponentTwo构造器执行完毕");
    }

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @PostConstruct
    private void method(){
        logger.info("ComponentTwo构造方法执行完毕，注入完成，开始执行postconstruct标注的方法");
    }
}
