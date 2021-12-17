package com.shenzp.springbootdemo.springbootdemo.postconstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * description: 轻量级操作使用postconstruction，时间长的操作可以使用独立线程执行
 *              初始化操作放在commandLineRunner或者applicationRunner中去执行
 */
@Component
public class ComponentOne {

    public ComponentOne() {
        logger.info("ComponentOne构造方法执行");
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostConstruct
    private void method() {
        logger.info("ComponentOne构造器执行完毕，注入完毕，开始执行postconstruct标注的方法");
    }
}
