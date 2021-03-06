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
public enum ResultEnum {

    USERNAME_OR_PASSWORD_CANT_EMPTY(1, "用户名或者密码不能为空"),
    USERNAME_ALREADY_EXIST(2, "用户名已存在"),
    PASSWORD_LENGTH_INVALID(3, "密码长度不合规"),
    PASSWORD_CONFIRM_NOT_EQUAL(4, "两次密码输入不一致"),
    USERNAME_OR_PASSWORD_ERROR(5, "用户名或密码输入错误"),
    CATEGORY_IS_NOT_EXIST(6, "分类不存在"),

    PARAMETER_CANT_EMPTY(7, "参数不能为空"),
    PARAMETER_ERROR(8, "参数错误"),

    // 支付方式
    PAY_METHOD_NOT_SUPPORTED(9, "支付方式不支持");

    private final Integer code;
    private final String message;
}
