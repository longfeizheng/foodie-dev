package com.niocoder.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
@AllArgsConstructor
@Getter
public enum SexEnum {
    WOMAN(0, "女"),
    MAN(1, "男"),
    SECRET(2, "保密");

    /**
     * 类别
     */
    private final Integer type;

    /**
     * 值
     */
    private final String value;
}