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
public enum YesNoEnum {
    NO(0, "否"),
    YES(1, "是");

    /**
     * 类别
     */
    private final Integer type;

    /**
     * 值
     */
    private final String value;
}
