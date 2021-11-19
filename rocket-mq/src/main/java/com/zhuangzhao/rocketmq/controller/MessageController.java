package com.zhuangzhao.rocketmq.controller;

import com.zhuangzhao.rocketmq.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-11-19 09:11
 */
@RestController
@RequestMapping(value = "/api/message")
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    @RequestMapping(value = "/send")
    public String sendMessage(@RequestParam String msg) {
        messageProducer.sendMessage(msg);
        return "Success";
    }
}
