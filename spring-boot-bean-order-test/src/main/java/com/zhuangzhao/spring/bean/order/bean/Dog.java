package com.zhuangzhao.spring.bean.order.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2019-07-03 10:17
 */
@Component
public class Dog implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("dog   not order.");
    }
}
