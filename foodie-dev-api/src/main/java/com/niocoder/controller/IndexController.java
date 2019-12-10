package com.niocoder.controller;

import com.niocoder.common.JSONVO;
import com.niocoder.enums.ResultEnum;
import com.niocoder.enums.YesNoEnum;
import com.niocoder.pojo.Carousel;
import com.niocoder.pojo.Category;
import com.niocoder.pojo.vo.CategoryVO;
import com.niocoder.pojo.vo.NewItemsVO;
import com.niocoder.service.CarouselService;
import com.niocoder.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Api(value = "首页", tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("/index")
@Slf4j
public class IndexController {

    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 获取全部轮播图记录
     */
    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public JSONVO carouse() {
        List<Carousel> carouselList = carouselService.queryAll(YesNoEnum.YES.getType());
        return JSONVO.ok(carouselList);
    }

    /**
     * 首页分类展示需求：
     * 1. 第一次刷新主页查询大分类，渲染展示到首页
     * 2. 如果鼠标移到大分类，则加载其子分类的内容。如果已经存在子分类，则不需要加载（懒加载）
     */
    @ApiOperation(value = "获取商品分类（一级分类）", notes = "获取商品分类（一级分类）", httpMethod = "GET")
    @GetMapping("/cats")
    public JSONVO categories() {
        List<Category> categoryList = categoryService.queryAllRootLevelCategory();
        return JSONVO.ok(categoryList);
    }

    /**
     * 子分类
     *
     * @param rootCatId 一级分类id
     */
    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public JSONVO subCategory(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable(name = "rootCatId") Integer rootCatId) {
        log.info("rootCatId: [{}]", rootCatId);

        if (rootCatId == null) {
            return JSONVO.errorMap(ResultEnum.CATEGORY_IS_NOT_EXIST.getMessage());
        }

        List<CategoryVO> categoryVOList = categoryService.querySubCategoryList(rootCatId);
        return JSONVO.ok(categoryVOList);
    }

    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据", notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public JSONVO sixNewItems(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable(name = "rootCatId") Integer rootCatId) {
        log.info("rootCatId: [{}]", rootCatId);

        if (rootCatId == null) {
            return JSONVO.errorMap(ResultEnum.CATEGORY_IS_NOT_EXIST.getMessage());
        }

        List<NewItemsVO> newItemsVOList = categoryService.querySixNewItemsLazy(rootCatId);
        return JSONVO.ok(newItemsVOList);
    }
}
