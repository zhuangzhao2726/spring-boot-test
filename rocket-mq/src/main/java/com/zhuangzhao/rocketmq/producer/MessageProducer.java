package com.zhuangzhao.rocketmq.producer;

import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-11-19 09:33
 */
@Service
public class MessageProducer {

    @Value("${rocketmq.producer.topic:zhuangzhao_test}")
    private String topic;

    @Autowired
    private MQProducer producer;

    public void sendMessage(String msg) {
        Message message = new Message(topic, msg.getBytes());
        try {
            producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
