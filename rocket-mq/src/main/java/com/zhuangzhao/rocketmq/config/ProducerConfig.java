package com.zhuangzhao.rocketmq.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-11-19 09:23
 */
@Configuration
public class ProducerConfig {

    @Value("${rocketmq.producer.namesrvAddr:8.142.87.181:9876}")
    private String namesrvAddr;


    @Bean
    public MQProducer producer() {
        DefaultMQProducer prooducer = new DefaultMQProducer("zhuangzhao_test_prooducer");
        prooducer.setNamesrvAddr(namesrvAddr);
        try {
            prooducer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return prooducer;
    }
}
