package com.zhuangzhao.spring.bean.order.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2019-07-03 10:26
 */
@Order(2)
@Component
public class Cow implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cow   order = 2.");
    }
}
