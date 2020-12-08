package com.zhuangzhao.spring.boot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-01-07 19:30
 */
public class ThreadLocalTest {

    public static final ThreadLocal userThreadLocal = new ThreadLocal();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Task()).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------------");

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            singleThreadExecutor.submit(new Task());
        }
        singleThreadExecutor.shutdown();
    }
}







class Task implements Runnable{

    @Override
    public void run() {

        Map map = (HashMap)ThreadLocalTest.userThreadLocal.get();
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put(UUID.randomUUID().toString(), 0);
        ThreadLocalTest.userThreadLocal.set(map);
        Manage manage = new Manage();
        manage.testThreadLocal();
    }
}




class Manage {

    public void testThreadLocal() {
        Map map = (HashMap)ThreadLocalTest.userThreadLocal.get();
        System.out.println("map size = " + map.size());
    }
}
