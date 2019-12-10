package com.niocoder.common;

import com.google.gson.Gson;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
public class GSONUtil {

    private static final Gson gson = new Gson();

    /**
     * 对象转Json字符串
     */
    public static <T> String obj2String(T src) {
        return gson.toJson(src);
    }
}
