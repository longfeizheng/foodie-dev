package com.niocoder.pojo.bo;

import lombok.Data;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
@Data
public class UserBO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 第二次输入的密码
     */
    private String confirmPassword;
}
