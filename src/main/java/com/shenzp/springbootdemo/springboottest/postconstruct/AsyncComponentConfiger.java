package com.shenzp.springbootdemo.springboottest.postconstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @描述
 * @创建人 szp
 * @修改人和其它信息
 */

@Configuration
@EnableAsync
public class AsyncComponentConfiger {
   private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Bean(name="asyncComponentExecutor")
    public Executor asyncComponentExecutor(){

        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(4);
        //设置失效时间
        executor.setKeepAliveSeconds(10);
        //最大线程数为当前cpu核数*2
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors()*2);
        //设置线程队列大小
        executor.setQueueCapacity(100);
        //设置线程名前缀
        executor.setThreadNamePrefix("aysncComponent-");
        //设置线程池拒绝策略，默认为abortPolicy
        //abortPolicy:丢弃任务，抛出rejectedExecutionException
        //discardPolicy：丢弃任务，不抛出异常
        //discardOldestPolicy：丢弃最前面的任务，重新执行被拒绝的任务
        //callerRunsPolicy：由调用线程执行该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        //初始化线程池
        executor.initialize();
        logger.info("线程池初始化完毕");
        return executor;
    }

}
