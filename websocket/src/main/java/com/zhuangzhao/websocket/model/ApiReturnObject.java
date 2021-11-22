package com.zhuangzhao.websocket.model;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-11-21 10:17
 */
public class ApiReturnObject {

    private boolean success;

    private String message;

    private String cid;


    public ApiReturnObject(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiReturnObject(boolean success, String message, String cid) {
        this.success = success;
        this.message = message;
        this.cid = cid;
    }
}
