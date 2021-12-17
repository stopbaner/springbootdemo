package com.shenzp.springbootdemo.springboottest.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * applicationRunner在项目启动结束后执行，初始化操作可以放在其中
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(ApplicationArguments args) {
        logger.info("applicationRunner参数{},{}",args.getNonOptionArgs(),args.getOptionNames());
        logger.info("项目启动完成，MyApplicationRunner执行完成");
    }
}
