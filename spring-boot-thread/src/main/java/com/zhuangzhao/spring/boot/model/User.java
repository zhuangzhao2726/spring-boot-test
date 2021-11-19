package com.zhuangzhao.spring.boot.model;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-01-01 18:09
 */
public class User {
    private String name;

    private Integer age;

    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
