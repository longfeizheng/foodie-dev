package com.niocoder.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Data
public class CategoryVO {
    /**
     * id
     */
    private Integer id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 商品类型
     */
    private String type;

    /**
     * 父级id
     */
    private Integer fatherId;

    /**
     * 三级分类VO集合，前端就是这个字段命名
     */
    private List<SubCategoryVO> subCatList;
}