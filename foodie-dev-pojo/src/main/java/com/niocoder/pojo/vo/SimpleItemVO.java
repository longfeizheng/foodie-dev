package com.niocoder.pojo.vo;

import lombok.Data;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Data
class SimpleItemVO {
    /**
     * 商品Id
     */
    private String itemId;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 商品图片地址
     */
    private String itemUrl;
}