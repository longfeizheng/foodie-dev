package com.niocoder.common;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * 本类可提供给H5/ios/安卓/公众号/小程序使用
 * 前端接受此类数据（json object）后，可自行根据业务去实现相关功能
 *
 * 200：表示成功
 * 500：表示错误，错误信息在msg字段中
 * 501：bean验证错误，不管多少个错误都以map形式返回
 * 502：拦截器拦截到用户token出错
 * 555：异常抛出信息
 * 556：用户qq校验异常
 */
@Data
public class JSONVO {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    @JsonIgnore
    private String ok;    // 不使用

    public static JSONVO build(Integer status, String msg, Object data) {
        return new JSONVO(status, msg, data);
    }

    public static JSONVO build(Integer status, String msg, Object data, String ok) {
        return new JSONVO(status, msg, data, ok);
    }

    public static JSONVO ok(Object data) {
        return new JSONVO(data);
    }

    public static JSONVO ok() {
        return new JSONVO(null);
    }

    public static JSONVO errorMsg(String msg) {
        return new JSONVO(500, msg, null);
    }

    public static JSONVO errorMag(Object data) {
        return new JSONVO(501, "error", data);
    }

    public static JSONVO errorTokenMsg(String msg) {
        return new JSONVO(502, msg, null);
    }

    public static JSONVO errorException(String msg) {
        return new JSONVO(555, msg, null);
    }

    public static JSONVO errorUserQQ(String msg) {
        return new JSONVO(556, msg, null);
    }

    public JSONVO() {

    }

    public JSONVO(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JSONVO(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public JSONVO(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }
}