package com.zhuangzhao.spring.bean.order.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2019-07-03 10:24
 */
@Order(0)
@Component
public class Pig implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("pig   order = 0.");
    }
}
