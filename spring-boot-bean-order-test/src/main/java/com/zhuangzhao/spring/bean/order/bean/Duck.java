package com.zhuangzhao.spring.bean.order.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2019-07-03 10:26
 */
@Order(Integer.MIN_VALUE)
@Component
public class Duck implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("duck    order = " + Integer.MIN_VALUE);
    }
}
