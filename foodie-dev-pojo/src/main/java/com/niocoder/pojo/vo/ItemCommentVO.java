package com.niocoder.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Data
public class ItemCommentVO {
    /**
     * 评价等级
     */
    private int commentLevel;

    /**
     * 内容
     */
    private String content;

    /**
     * 规格名
     */
    private String specName;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 用户头像
     */
    private String userFace;

    /**
     * 昵称
     */
    private String nickname;
}
