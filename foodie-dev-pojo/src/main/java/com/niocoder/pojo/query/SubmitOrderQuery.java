package com.niocoder.pojo.query;

import lombok.Data;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Data
public class SubmitOrderQuery {
    /**
     * 用户Id
     */
    private String userId;

    /**
     * 商品规格Id
     */
    private String itemSpecIds;

    /**
     * 地址Id
     */
    private String addressId;

    /**
     * 支付方式
     */
    private Integer payMethod;

    /**
     * 买家留言
     */
    private String leftMsg;
}