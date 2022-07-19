package com.ytz.web.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.utils
 * @className: ResultMap
 * @author: 30671
 * @description: 回显信息格式
 * @date: 2022/7/3
 * @version: 1.0
 */

public class ResultMap {
    private final Map<String, Object> data;

    /**
     * 回显信息格式
     * status 状态
     * msg    信息
     * data   数据
     * token  验证
     * Extra  额外信息
     */

    public ResultMap() {
        data = new HashMap<>();
        this.setData("");
    }

    public ResultMap(Integer status, String msg, Object data, String token) {
        this.data = new HashMap<>();
        this.setStatus(status);
        this.setMsg(msg);
        this.setData(data);
        this.setToken(token);
    }

    public ResultMap(Enum status, Object data) {
        this.data = new HashMap<>();
        this.setEnum(status);
        this.setData(data);
    }

    public ResultMap(Enum status) {
        this.data = new HashMap<>();
        this.setEnum(status);
        this.setData("");
    }

    public void setEnum(Enum status) {
        this.setStatus(status.ordinal());
        this.setMsg(status.toString());
    }

    public void setToken(String token) {
        data.put("token", token);
    }

    public void setStatus(Integer status) {
        data.put("status", status);
    }

    public void setMsg(String msg) {
        data.put("msg", msg);
    }

    public void setData(Object data) {
        this.data.put("data", data);
    }

    public void put(String key, Object data) {
        this.data.put(key, data);
    }

    public String toJson() {
        return JsonUtils.mapToJson(data);
    }
}