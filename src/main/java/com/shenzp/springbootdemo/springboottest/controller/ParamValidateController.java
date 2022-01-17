package com.shenzp.springbootdemo.springboottest.controller;

import com.shenzp.springbootdemo.springboottest.domain.MyDomain;
import com.shenzp.springbootdemo.springboottest.util.MyValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class ParamValidateController {

    @Resource
    private MyValidator myValidator;

    //只针对当前的Controller有效
    @InitBinder
    public void InitBinder(WebDataBinder binder) {
        binder.addValidators(myValidator);
        //前端传入的时间格式必须是"yyyy-MM-dd HH:mm:ss"效果!
        //simpleDateFormat是线程不安全的，DateTimeFormatter是线程安全的
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置为严格解析
        //setLenient用于设置Calendar是否宽松解析字符串，如果为false，则严格解析；默认为true，宽松解析
        df.setLenient(false);
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, dateEditor);
        log.info("ParamValidateController的InitBinder初始化完成");
    }

    @RequestMapping("/validateMyDomain")
    public void validateMyDomain(@Validated MyDomain myDomain) {

    }

}
