package com.zhuangzhao.spring.boot.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-01-02 02:09
 */
public class LogResultAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[请求结果] method:" +   method.getName() + ", args:" + Arrays.toString(args) + "result = " + returnValue);
    }
}
