package com.niocoder.controller;

import com.niocoder.common.CookieUtil;
import com.niocoder.common.GSONUtil;
import com.niocoder.common.JSONVO;
import com.niocoder.common.MD5Util;
import com.niocoder.enums.ResultEnum;
import com.niocoder.pojo.Users;
import com.niocoder.pojo.bo.UserBO;
import com.niocoder.pojo.vo.UserVO;
import com.niocoder.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
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
    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public JSONVO usernameIsExist(@RequestParam String username) {

        log.info("username: [{}]", username);

        // 判断用户名不能为空
        if (StringUtils.isEmpty(username)) {
            return JSONVO.errorMsg(ResultEnum.USERNAME_OR_PASSWORD_CANT_EMPTY.getMessage());
        }

        // 查找注册的用户名是否存在
        if (userService.queryUsernameIsExist(username)) {
            return JSONVO.errorMsg(ResultEnum.USERNAME_ALREADY_EXIST.getMessage());
        }

        // 请求成功，用户名没有重复
        return JSONVO.ok();
    }

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/register")
    public JSONVO register(@RequestBody UserBO userBO) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        // 判断用户名和密码必须不为空
        if (StringUtils.isEmpty(username)
                || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(confirmPassword)) {
            return JSONVO.errorMsg(ResultEnum.USERNAME_OR_PASSWORD_CANT_EMPTY.getMessage());
        }

        // 查询用户名是否存在
        if (userService.queryUsernameIsExist(username)) {
            return JSONVO.errorMsg(ResultEnum.USERNAME_ALREADY_EXIST.getMessage());
        }

        // 密码长度不能少于6位
        if (password.length() < 6) {
            return JSONVO.errorMsg(ResultEnum.PASSWORD_LENGTH_INVALID.getMessage());
        }

        // 判断两次密码是否一致
        if (!Objects.equals(password, confirmPassword)) {
            return JSONVO.errorMsg(ResultEnum.PASSWORD_CONFIRM_NOT_EQUAL.getMessage());
        }

        // 实现注册
        userService.createUser(userBO);

        return JSONVO.ok();
    }

    /**
     * 用户登录
     */
    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public JSONVO login(@RequestBody UserBO userBO, HttpServletRequest request,
                        HttpServletResponse response) throws NoSuchAlgorithmException {
        log.info("userBO: [{}]", userBO);

        String username = userBO.getUsername();
        String password = userBO.getPassword();

        // 判断用户名和密码必须不为空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return JSONVO.errorMsg(ResultEnum.USERNAME_OR_PASSWORD_CANT_EMPTY.getMessage());
        }

        // 实现登录
        Users users = userService.queryUserForLogin(username, MD5Util.getMD5Str(password));
        if (users == null) {
            return JSONVO.errorMsg(ResultEnum.USERNAME_OR_PASSWORD_ERROR.getMessage());
        }

        // 封装用户视图对象
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(users, userVO);

        // 设置cookie，cookie值必须被编码，因为cookie值很有可能有违法字符
        CookieUtil.setCookie(request, response, "user", GSONUtil.obj2String(userVO), true);


        return JSONVO.ok(users);
    }

    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public JSONVO logout(@RequestParam String userId, HttpServletRequest request, HttpServletResponse response) {
        log.info("userId: [{}]", userId);

        // 清除用户的相关信息的cookie
        CookieUtil.deleteCookie(request, response, "user");

        // todo 用户退出登录，需要清空购物车
        // todo 分布式会话中需要清除用户数据

        return JSONVO.ok();
    }
}
