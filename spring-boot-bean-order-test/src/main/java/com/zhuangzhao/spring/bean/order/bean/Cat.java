package com.zhuangzhao.spring.bean.order.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2019-07-03 10:25
 */
@Order(5)
@Component
public class Cat implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat   order = 5.");
    }
}
