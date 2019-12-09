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
    PASSWORD_CONFIRM_NOT_EQUAL(4, "两次密码输入不一致");

    private final Integer code;
    private final String message;
}
