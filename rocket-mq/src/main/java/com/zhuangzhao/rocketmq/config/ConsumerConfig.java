package com.zhuangzhao.rocketmq.config;

import io.netty.channel.DefaultChannelId;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-11-19 20:20
 */
@Configuration
public class ConsumerConfig {

    @Autowired
    private MessageListenerConcurrently listener;

    @Value("${rocketmq.producer.nameSrvAddr:8.142.87.181:9876}")
    private String nameSrvAddr;

    @Value("${rocketmq.producer.topic:zhuangzhao_test}")
    private String topic;


    @Bean
    public DefaultMQPushConsumer consumer() {

        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");

        // Specify name server addresses.
        consumer.setNamesrvAddr(nameSrvAddr);


        try {
            // Subscribe one more more topics to consume.
            consumer.subscribe(topic, "*");

            consumer.registerMessageListener(listener);

            DefaultChannelId.newInstance();

            //Launch the consumer instance.
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return consumer;
    }
}
