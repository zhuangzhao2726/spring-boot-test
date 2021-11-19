package com.zhuangzhao.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-11-19 20:37
 */
@Configuration
public class MessageConsumer implements MessageListenerConcurrently {

    public ConsumeConcurrentlyStatus consumeMessage( List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH;mm:ss");
        for (MessageExt msg : msgs) {
            System.out.println(format.format(new Date()) + " 消费消息：messageId = " + msg.getMsgId() +
                    ", key = " + msg.getKeys() + "; 消息内容: " + new String(msg.getBody()));
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
