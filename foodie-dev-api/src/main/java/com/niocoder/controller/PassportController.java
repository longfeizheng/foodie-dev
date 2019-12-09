package com.niocoder.controller;

import com.niocoder.com.niocoder.common.JSONResult;
import com.niocoder.enums.ResultEnum;
import com.niocoder.pojo.bo.UserBO;
import com.niocoder.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
@RestController
@RequestMapping("/passport")
@Slf4j
public class PassportController {

    @Autowired
    private UserService userService;

    /**
     * 用户名是否存在
     *
     * @param username 用户名
     * @return 状态码
     */
    @GetMapping("/usernameIsExist")
    public JSONResult usernameIsExist(@RequestParam String username) {

        log.info("username: [{}]", username);

        // 判断用户名不能为空
        if (StringUtils.isEmpty(username)) {
            return JSONResult.errorMsg(ResultEnum.USERNAME_OR_PASSWORD_CANT_EMPTY.getMessage());
        }

        // 查找注册的用户名是否存在
        if (userService.queryUsernameIsExist(username)) {
            return JSONResult.errorMsg(ResultEnum.USERNAME_ALREADY_EXIST.getMessage());
        }

        // 请求成功，用户名没有重复
        return JSONResult.ok();
    }

    @PostMapping("/register")
    public JSONResult register(@RequestBody UserBO userBO) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        // 判断用户名和密码必须不为空
        if (StringUtils.isEmpty(username)
                || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(confirmPassword)) {
            return JSONResult.errorMsg(ResultEnum.USERNAME_OR_PASSWORD_CANT_EMPTY.getMessage());
        }

        // 查询用户名是否存在
        if (userService.queryUsernameIsExist(username)) {
            return JSONResult.errorMsg(ResultEnum.USERNAME_ALREADY_EXIST.getMessage());
        }

        // 密码长度不能少于6位
        if (password.length() < 6) {
            return JSONResult.errorMsg(ResultEnum.PASSWORD_LENGTH_INVALID.getMessage());
        }

        // 判断两次密码是否一致
        if (!Objects.equals(password, confirmPassword)) {
            return JSONResult.errorMsg(ResultEnum.PASSWORD_CONFIRM_NOT_EQUAL.getMessage());
        }

        // 实现注册
        userService.createUser(userBO);

        return JSONResult.ok();
    }
}
