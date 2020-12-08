package com.zhuangzhao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-01-06 23:13
 */
@RestController
public class IndexController {




    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {




        return "";
    }
}
