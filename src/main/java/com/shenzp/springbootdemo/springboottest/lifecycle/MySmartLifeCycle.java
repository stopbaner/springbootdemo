package com.shenzp.springbootdemo.springboottest.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * SmartLifecycle自动执行通过isAutoStartup()控制
 */
@Component
public class MySmartLifeCycle implements SmartLifecycle {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Java volatile
     *     对变量的写操作不依赖于当前值
     *     该变量没有包含在具有其他变量的不变式中
     *     第一个条件就是不能是自增自减等操作，上文已经提到volatile不保证原子性。
     *     第二个条件我们来举个例子它包含了一个不变式 ：下界总是小于或等于上界
     *     多线程读取，立即可见，会促使单个线程的缓存失效
     */
    private  Boolean isStop = false;

    /**
     * 如果该`Lifecycle`类所在的上下文在调用`refresh`时,希望能够自己自动进行回调，则返回`true`,
     * false的值表明组件打算通过显式的start()调用来启动，类似于普通的Lifecycle实现。
     */
    @Override
    public boolean isAutoStartup() {
        return SmartLifecycle.super.isAutoStartup();
    }

    /**
     * SmartLifecycle子类的才有的方法，当isRunning方法返回true时，该方法才会被调用。
     * 很多框架中的源码中，都会把真正逻辑写在stop()方法内。 比如quartz和Redis的spring支持包。
     */
    @Override
    public void stop(Runnable callback) {
        logger.info("MySmartLifecycle容器停止，执行回调函数");
        SmartLifecycle.super.stop(callback);
    }

    /**
     * 如果有多个实现接口SmartLifecycle的类，则这些类的start的执行顺序按getPhase方法返回值从小到大执行。<br/>
     * 例如：1比2先执行，-1比0先执行。stop方法的执行顺序则相反，getPhase返回值较大类的stop方法先被调用，小的后被调用。
     */
    @Override
    public int getPhase() {
        return SmartLifecycle.super.getPhase();
    }

    @Override
    public void start() {
        logger.info("容器启动，MySmartLifeCycle执行操作");
        isStop = true;
    }

    /**
     * 接口Lifecycle子类的方法，只有非SmartLifecycle的子类才会执行该方法。<br/>
     * 1. 该方法只对直接实现接口Lifecycle的类才起作用，对实现SmartLifecycle接口的类无效。<br/>
     * 2. 方法stop()和方法stop(Runnable callback)的区别只在于，后者是SmartLifecycle子类的专属。
     */
    @Override
    public void stop() {
        logger.info("容器关闭，MySmartLifeCycle执行操作");
    }

    @Override
    public boolean isRunning() {
        logger.info("MySmartLifeCycle执行操作运行状态检查");
        return isStop;
    }
}
