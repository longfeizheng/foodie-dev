package com.niocoder.service;

import com.niocoder.pojo.Category;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
public interface CategoryService {

    List<Category> queryAllRootLevelCategory();

}
