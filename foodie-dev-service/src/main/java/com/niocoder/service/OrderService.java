package com.niocoder.service;

import com.niocoder.pojo.query.SubmitOrderQuery;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
public interface OrderService {
    /**
     * 创建订单相关信息
     */
    void createOrder(SubmitOrderQuery submitOrderQuery);
}
