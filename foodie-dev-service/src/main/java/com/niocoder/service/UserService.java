package com.niocoder.service;

import com.niocoder.pojo.Users;
import com.niocoder.pojo.bo.UserBO;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
public interface UserService {
    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 创建用户
     */
    Users createUser(UserBO userBO);


    Users queryUserForLogin(String username, String password);
}
