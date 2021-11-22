package com.zhuangzhao.websocket.util;

import com.zhuangzhao.websocket.model.ApiReturnObject;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-11-21 10:18
 */
public class ApiReturnUtil {

    public static ApiReturnObject error(String s) {
        return new ApiReturnObject(false, s);

    }

    public static ApiReturnObject success(String cid) {
        return new ApiReturnObject(true, "", cid);
    }
}
