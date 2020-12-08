package com.zhuangzhao.spring.boot.hystrix;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.math.RandomUtils;
import rx.Observable;
import rx.internal.util.InternalObservableUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-12-01 00:17
 */
public class Test {


    public static void main(String[] args) throws Exception {
        Observable<Integer> source = Observable.interval(50, TimeUnit.MILLISECONDS).map(i -> RandomUtils.nextInt(2));
        source.window(1, TimeUnit.SECONDS).subscribe(window -> {
            int[] metrics = new int[2];
            window.subscribe(i -> metrics[i]++,
                    InternalObservableUtils.ERROR_NOT_IMPLEMENTED,
                    () -> System.out.println("窗口Metrics:" + JSON.toJSONString(metrics)));
        });
        TimeUnit.SECONDS.sleep(3);
    }
}
