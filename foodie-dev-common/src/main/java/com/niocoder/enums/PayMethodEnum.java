package com.niocoder.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@AllArgsConstructor
@Getter
public enum PayMethodEnum {
    /**
     * 微信支付
     */
    WEIXIN(1, "微信"),

    /**
     * 支付宝支付
     */
    ALIPAY(2, "支付宝");

    /**
     * 类型
     */
    private final Integer type;

    /**
     * 值
     */
    private final String value;
}

