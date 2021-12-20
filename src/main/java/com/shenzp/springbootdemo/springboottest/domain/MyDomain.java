package com.shenzp.springbootdemo.springboottest.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MyDomain implements InitializingBean {

    @Value("${address:unknown}")
    private String address;

    @Value("${age:unknown}")
    private Integer age;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void afterPropertiesSet() {
        logger.info("domain："+address+","+age);
    }
}
