package com.niocoder.service.impl;

import com.niocoder.enums.CategoryTypeEnum;
import com.niocoder.mapper.CategoryMapper;
import com.niocoder.pojo.Category;
import com.niocoder.pojo.vo.CategoryVO;
import com.niocoder.pojo.vo.NewItemsVO;
import com.niocoder.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllRootLevelCategory() {
        return categoryMapper.select(new Category().setType(CategoryTypeEnum._1_CATEGORY.getType()));
    }

    @Override
    public List<CategoryVO> querySubCategoryList(Integer rootCategoryId) {
        return categoryMapper.selectByRootCategoryId(rootCategoryId);
    }

    @Override
    public List<NewItemsVO> querySixNewItemsLazy(Integer rootCategoryId) {
        Map<String, Object> map = new HashMap<>();
        map.put("rootCategoryId", rootCategoryId);

        return categoryMapper.querySixNewItemsLazy(map);
    }
}
