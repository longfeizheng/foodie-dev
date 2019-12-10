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
public enum CategoryTypeEnum {
    _1_CATEGORY(1, "一级分类");
    /**
     * 类别
     */
    private final Integer type;

    /**
     * 值
     */
    private final String value;
}