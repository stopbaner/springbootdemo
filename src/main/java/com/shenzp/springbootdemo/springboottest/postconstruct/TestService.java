package com.shenzp.springbootdemo.springboottest.postconstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private ComponentOne componentOne;

    public void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            componentOne.method();
        }
    }
}
