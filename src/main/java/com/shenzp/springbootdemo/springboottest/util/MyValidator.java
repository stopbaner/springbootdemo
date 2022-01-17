package com.shenzp.springbootdemo.springboottest.util;

import com.shenzp.springbootdemo.springboottest.domain.MyDomain;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class MyValidator implements Validator {
    //判断是否是父类，在validate方法中进行转换是先执行
    @Override
    public boolean supports(Class<?> clazz) {
        //isAssignableFrom判断是否是一个类的父类，instanceOf判断是否是一个类的子类
        return MyDomain.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MyDomain myDomain = (MyDomain) target;
        //配置字段验证信息
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "500", "address字段为空");
//        if (myDomain.getAge() > 200 || myDomain.getAge() <= 0) {
//            errors.rejectValue("age", "500", "年龄在1-200之间");
//        }
    }
}
