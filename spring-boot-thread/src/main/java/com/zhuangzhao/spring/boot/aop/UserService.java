package com.zhuangzhao.spring.boot.aop;

import com.zhuangzhao.spring.boot.model.User;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-01-02 02:04
 */
public interface UserService {

    User createUser(String userName, Integer age);
}
