package com.zhuangzhao.spring.boot;

import com.zhuangzhao.spring.boot.aop.UserService;
import com.zhuangzhao.spring.boot.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-01-01 18:10
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/zhuangzhao.xml");
        User user = applicationContext.getBean(User.class);
        System.out.println(user.toString());


        UserService userService = (UserService) applicationContext.getBean("userServiceProxy");
        userService.createUser("dubbo", 24);
    }
}
