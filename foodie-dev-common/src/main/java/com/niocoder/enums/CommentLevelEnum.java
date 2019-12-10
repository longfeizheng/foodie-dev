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
public enum CommentLevelEnum {
    GOOD(1, "好评"),
    NORMAL(2, "中评"),
    BAD(3, "差评");

    private final Integer type;
    private final String value;
}
