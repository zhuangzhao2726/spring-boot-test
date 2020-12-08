package com.zhuangzhao.cglib.proxy;

import com.zhuangzhao.jdk.proxy.Hello;
import com.zhuangzhao.jdk.proxy.impl.HelloImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-12-07 22:48
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Hello target;


    public Object getProxy(Hello hello) {
        target = hello;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(hello.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib动态代理开始执行");
        Object invoke = method.invoke(target, objects);
        System.out.println("Cglib动态代理执行完成");
        return invoke;
    }


    public static void main(String[] args) {

        CglibProxyFactory proxyFactory = new CglibProxyFactory();
        Hello proxy = (Hello)proxyFactory.getProxy(new HelloImpl());
        proxy.sayHello();
    }
}
