package com.niocoder.service.impl;

import com.niocoder.com.niocoder.common.DateUtil;
import com.niocoder.com.niocoder.common.IdWorker;
import com.niocoder.com.niocoder.common.MD5Util;
import com.niocoder.enums.SexEnum;
import com.niocoder.mapper.UsersMapper;
import com.niocoder.pojo.Users;
import com.niocoder.pojo.bo.UserBO;
import com.niocoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Objects;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * 默认用户头像地址
     */
    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";


    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public boolean queryUsernameIsExist(String username) {
        return Objects.nonNull(usersMapper.selectOne(new Users().setUsername(username)));
    }

    @Override
    public Users createUser(UserBO userBO) {
        try {
            Users users = Users.builder()
                    // id
                    .id(String.valueOf(idWorker.nextId()))
                    // 用户名
                    .username(userBO.getUsername())
                    // 密码
                    .password(MD5Util.getMD5Str(userBO.getPassword()))
                    // 昵称
                    .nickname(userBO.getUsername())
                    // 头像
                    .face(USER_FACE)
                    // 生日
                    .birthday(DateUtil.stringToDate("1900-01-01"))
                    // 性别
                    .sex(SexEnum.SECRET.getType())
                    // 创建时间
                    .createdTime(new Date())
                    // 更新时间
                    .updatedTime(new Date())
                    .build();

            usersMapper.insertSelective(users);
            return users;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
