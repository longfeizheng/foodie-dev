package com.niocoder.pojo.vo;

import lombok.Data;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Data
class SubCategoryVO {
    /**
     * id
     */
    private Integer subId;

    /**
     * 商品名
     */
    private String subName;

    /**
     * 商品类型
     */
    private String subType;

    /**
     * 父级id
     */
    private Integer subFatherId;
}

