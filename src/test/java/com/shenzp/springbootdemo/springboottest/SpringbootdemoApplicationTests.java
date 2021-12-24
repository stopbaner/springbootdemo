package com.shenzp.springbootdemo.springboottest;

import com.shenzp.springbootdemo.springboottest.postconstruct.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootdemoApplicationTests {

    @Autowired
    private TestService testService;

    @Test
    void contextLoads() throws InterruptedException {
        testService.test();
    }

}
