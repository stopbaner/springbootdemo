package com.shenzp.springbootdemo.springboottest.lifecycle;

import ch.qos.logback.core.spi.LifeCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 调用AbstractApplicationContext#start方法或者显式调用后生效
 */
@Component
public class MyLifeCycle implements LifeCycle {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private volatile boolean isStop = true;

    /**
     * 容器开启后执行
     */
    @Override
    public void start() {

        logger.info("容器启动，执行MyLifeCycle操作");
    }

    /**
     * 容器停止时执行
     */
    @Override
    public void stop() {

        logger.info("容器关闭，执行MyLifeCycle操作");
    }

    /**
     * @return
     */
    @Override
    public boolean isStarted() {

        logger.info("检查容器的运行状态：{}，", isStop);
        return isStop;
    }
}
