package com.niocoder.pojo.query;

import lombok.Data;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Data
public class ShopCartQuery {
    /**
     * 商品Id
     */
    private String itemId;

    /**
     * 商品图片url
     */
    private String itemImgUrl;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 规格Id
     */
    private String specId;

    /**
     * 规格名称
     */
    private String specName;

    /**
     * 购买的商品数量
     */
    private Integer buyCounts;

    /**
     * 折扣
     */
    private String priceDiscount;

    /**
     * 商品正常价格
     */
    private String priceNormal;
}
