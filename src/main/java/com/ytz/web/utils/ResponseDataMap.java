package com.ytz.web.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.utils
 * @className: ResponseDataMap
 * @author: 30671
 * @description: 回显信息格式
 * @date: 2022/7/3
 * @version: 1.0
 */

public class ResponseDataMap {
    private Map<String, Object> sendData;

    /**
     * 回显信息格式
     * status 状态
     * msg    信息
     * data   数据
     * Extra  额外信息
     */

    public ResponseDataMap() {
        sendData = new HashMap<>();
        this.setData("");
    }

    public ResponseDataMap(Integer status, String msg, Object data) {
        sendData = new HashMap<>();
        this.setStatus(status);
        this.setMsg(msg);
        this.setData(data);
    }

    public void setStatus(Integer status) {
        sendData.put("status", status);
    }

    public void setMsg(String msg) {
        sendData.put("msg", msg);
    }

    public void setData(Object data) {
        sendData.put("data", data);
    }

    public void put(String key, Object data) {
        sendData.put(key, data);
    }

    public String toJson() {
        return JsonUtils.mapToJson(sendData);
    }
}
