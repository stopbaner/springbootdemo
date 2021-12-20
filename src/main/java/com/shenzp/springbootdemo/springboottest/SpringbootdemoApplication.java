package com.shenzp.springbootdemo.springboottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class SpringbootdemoApplication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
        //第二种启动方式(web方式)
        //new SpringApplicationBuilder().main(SpringbootdemoApplication.class).web(WebApplicationType.NONE).build(args);
    }

    @PostConstruct
    public void afterInit() {
        logger.info("构造方法与autowired执行完毕,servlet的init方法未执行");
    }

    @PreDestroy
    public void destroy() {
        logger.info("servlet的destroy执行完毕");
    }

}
