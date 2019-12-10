package com.niocoder.pojo.query;

import lombok.Data;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Data
public class AddressQuery {
    /**
     * 地址Id
     */
    private String addressId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 收件人
     */
    private String receiver;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 细节
     */
    private String detail;
}
