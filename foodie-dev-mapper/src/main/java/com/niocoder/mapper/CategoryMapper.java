package com.niocoder.mapper;

import com.niocoder.common.mybatis.TkMapper;
import com.niocoder.pojo.Category;
import com.niocoder.pojo.vo.CategoryVO;
import com.niocoder.pojo.vo.NewItemsVO;

import java.util.List;
import java.util.Map;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
public interface CategoryMapper extends TkMapper<Category> {

    /**
     * 根据一级分类id查询子分类信息
     *
     * @param rootCategoryId 一级分类id
     * @return 子分类信息
     */
    List<CategoryVO> selectByRootCategoryId(Integer rootCategoryId);


    List<NewItemsVO> querySixNewItemsLazy(Map<String, Object> map);
}
