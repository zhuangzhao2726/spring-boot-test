package com.zhuangzhao.spring.boot;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-11-27 18:34
 */
public class RateLimiterTest {


    RateLimiter rateLimiter;

    public RateLimiterTest(int maxQps) {
        rateLimiter = RateLimiter.create(1000);
    }
}
