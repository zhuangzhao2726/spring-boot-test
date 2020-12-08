package com.zhuangzhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;


@EnableRetry
@SpringBootApplication
public class SpringRetryDemo {

    public void helloWorld() throws Throwable {
        /*
         * spring-retry1.3.x版本开始提供建造者模式支持了，可
         * RetryTemplate template = RetryTemplate.builder()
                .maxAttempts(5)
                .customPolicy(new SimpleRetryPolicy()).build();
         */
        RetryTemplate template = new RetryTemplate();
        // 设置重试策略
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        simpleRetryPolicy.setMaxAttempts(5);
        template.setRetryPolicy(simpleRetryPolicy);
        // 执行
        Object result = template.execute(
                new RetryCallback<Object, Throwable>() {
                    @Override
                    public Object doWithRetry(RetryContext context) throws Throwable {
                        // 第一次请求，不算重试， 所以第一次请求时，context.getRetryCount()值为0
                        System.out.println(context.getRetryCount());
                        throw new RuntimeException("第" + (context.getRetryCount() + 1) + "次调用失败!");
                    }
                },
                new RecoveryCallback<Object>() {
                    @Override
                    public Object recover(RetryContext context) throws Exception {
                        Throwable lastThrowable = context.getLastThrowable();
                        return "走recover逻辑了! \t异常类是" + lastThrowable.getClass().getName()
                                + "\t异常信息是" + lastThrowable.getMessage();
                    }
                });
        System.out.println(result);
    }

    @Retryable
    public String run( ) {
        System.out.println("来这里了");
        throw new RuntimeException("抛异常了");
    }


    public static void main(String[] args) throws Throwable {
        ApplicationContext context = new SpringApplication(SpringRetryDemo.class).run(args);
        SpringRetryDemo demo = context.getBean(SpringRetryDemo.class);
        demo.run();
    }
}