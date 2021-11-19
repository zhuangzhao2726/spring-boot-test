package com.zhuangzhao.spring.boot.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-01-02 02:07
 */
public class LogArgAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[请求参数] method:" +   method.getName() + ", args:" + Arrays.toString(args));
    }
}
