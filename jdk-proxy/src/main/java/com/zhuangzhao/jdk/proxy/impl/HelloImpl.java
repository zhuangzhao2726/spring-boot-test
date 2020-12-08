package com.zhuangzhao.jdk.proxy.impl;

import com.zhuangzhao.jdk.proxy.Hello;

public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }
}