package com.ytz.web.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.utils
 * @className: FastJsonUtils
 * @author: 30671
 * @description: JSON
 * @date: 2022/4/16
 * @version: 1.0
 */

public class FastJsonUtils {
    private static final SerializeConfig config;
    /**
     * 输出空值字段
     * 如果数组结果为null,则输出为[],而不是null
     * 数值字段为null,则输出为0,而不是null
     * Boolean字段为null,则输出为false,而不是null
     * 字符类型如果为null,则输出为" ",而不是null
     */
    private static final SerializerFeature[] features = {
            SerializerFeature.WriteMapNullValue,
            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullNumberAsZero,
            SerializerFeature.WriteNullBooleanAsFalse,
            SerializerFeature.WriteNullStringAsEmpty
    };

    static {
        config = new SerializeConfig();
        // 使用和json-lib兼容的日期输出格式
        config.put(java.util.Date.class, new JSONLibDataFormatSerializer());
        // 使用和json-lib兼容的日期输出格式
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer());
    }

    /**
     * 避免实例化
     */
    private FastJsonUtils() {

    }


    /**
     * @MethodName: objectToJson
     * @Description: DONE : T 转 Json
     * @Author: 30671
     * @date: 2022/7/3 
     * @param: object
     * @return: java.lang.String
     */
    public static <T> String objectToJson(T object) {
        return JSONObject.toJSONString(object, config, features);
    }

    /**
     * @MethodName: listToJson
     * @Description: DONE : List<T> 转 Json
     * @Author: 30671
     * @date: 2022/4/16
     * @param: objectList
     * @return: java.lang.String
     */
    public static <T> String listToJson(List<T> objectList) {
        return JSONObject.toJSONString(objectList, config, features);
    }

    /**
     * @MethodName: mapToJson
     * @Description: DONE : Map<String,T> 转 Json
     * @Author: 30671
     * @date: 2022/4/16
     * @param: objectMap
     * @return: java.lang.String
     */
    public static <T> String mapToJson(Map<String, T> objectMap) {
        return JSONObject.toJSONString(objectMap, config, features);
    }

    /**
     * @MethodName: jsonToObject
     * @Description: DONE : Json 转 T
     * @Author: 30671
     * @date: 2022/4/16
     * @param: json
     * @param: typeReference
     * @return: T
     */
    public static <T> T jsonToObject(String json, TypeReference<T> typeReference) {
        return JSON.parseObject(json, typeReference);
    }
    
    /**
     * @MethodName: jsonToList
     * @Description: DONE : Json 转 List<T>
     * @Author: 30671
     * @date: 2022/4/16
     * @param: json
     * @param: typeReference
     * @return: java.util.List<T>
     */
    public static <T> List<T> jsonToList(String json, TypeReference<List<T>> typeReference) {
        return JSON.parseObject(json, typeReference);
    }
    
    /**
     * @MethodName: jsonToMap
     * @Description: DONE : Json 转 Map<String, T>
     * @Author: 30671
     * @date: 2022/4/16
     * @param: json
     * @param: typeReference
     * @return: java.util.Map<java.lang.String, T>
     */
    public static <T> Map<String, T> jsonToMap(String json, TypeReference<Map<String, T>> typeReference) {
        return JSONObject.parseObject(json, typeReference);
    }
}
