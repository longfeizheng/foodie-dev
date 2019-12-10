package com.niocoder.service.impl;

import com.niocoder.enums.CategoryTypeEnum;
import com.niocoder.mapper.CategoryMapper;
import com.niocoder.pojo.Category;
import com.niocoder.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllRootLevelCategory() {
        return categoryMapper.select(new Category().setType(CategoryTypeEnum._1_CATEGORY.getType()));
    }
}
