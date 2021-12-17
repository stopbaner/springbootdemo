package com.shenzp.springbootdemo.springboottest.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class MyCommandLineRunner implements CommandLineRunner {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) {
       logger.info("CommandLineRunner参数{}",args);
       logger.info("项目启动完成，MyCommandLineRunner执行完成");
    }
}
