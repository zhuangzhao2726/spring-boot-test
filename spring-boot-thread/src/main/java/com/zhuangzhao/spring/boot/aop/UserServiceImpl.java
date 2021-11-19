package com.zhuangzhao.spring.boot.aop;

import com.zhuangzhao.spring.boot.model.User;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-01-02 02:12
 */
public class UserServiceImpl implements UserService {

    private User user;

    public User createUser(String userName, Integer age) {
        user = new User();
        user.setUserName(userName);
        user.setAge(age);
        return user;
    }
}
