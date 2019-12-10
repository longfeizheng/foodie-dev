package com.niocoder.controller;

import com.niocoder.common.JSONVO;
import com.niocoder.common.PagingGridVO;
import com.niocoder.pojo.Items;
import com.niocoder.pojo.ItemsImg;
import com.niocoder.pojo.ItemsParam;
import com.niocoder.pojo.ItemsSpec;
import com.niocoder.pojo.vo.ItemInfoVO;
import com.niocoder.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
@RestController
@RequestMapping("/items")
@Slf4j
public class ItemsController {


    @Autowired
    private ItemService itemService;

    /**
     * 商品详情
     */
    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public JSONVO info(
            @ApiParam(name = "itemId", value = "商品Id", required = true)
            @PathVariable String itemId) {
        log.info("itemId: [{}]", itemId);

        if (StringUtils.isEmpty(itemId)) {
            return JSONVO.errorMsg(null);
        }

        Items items = itemService.queryItemById(itemId);
        List<ItemsImg> itemImageList = itemService.queryItemImageList(itemId);
        List<ItemsSpec> itemsSpecList = itemService.queryItemSpecList(itemId);
        ItemsParam itemsParam = itemService.queryItemParam(itemId);

        ItemInfoVO itemInfoVO = ItemInfoVO.builder()
                .item(items)
                .itemImgList(itemImageList)
                .itemSpecList(itemsSpecList)
                .itemParams(itemsParam)
                .build();

        return JSONVO.ok(itemInfoVO);
    }

    /**
     * 商品评价等级
     */
    @ApiOperation(value = "查询商品评价等级", notes = "查询商品评价等级", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public JSONVO commentLevel(
            @ApiParam(name = "itemId", value = "商品Id", required = true)
            @RequestParam String itemId) {
        log.info("itemId: [{}]", itemId);

        if (StringUtils.isEmpty(itemId)) {
            return JSONVO.errorMsg(null);
        }

        return JSONVO.ok(itemService.queryCommentCount(itemId));
    }

    /**
     * 商品评论
     */
    @ApiOperation(value = "查询商品评论", notes = "查询商品评论", httpMethod = "GET")
    @GetMapping("/comments")
    public JSONVO comments(
            @ApiParam(name = "itemId", value = "商品Id", required = true)
            @RequestParam String itemId,
            @ApiParam(name = "level", value = "评价等级")
            @RequestParam Integer level,
            @ApiParam(name = "page", value = "查询第几页")
            @RequestParam(defaultValue = "1") Integer page,
            @ApiParam(name = "pageSize", value = "分页的每一页显示的条数")
            @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("itemId: [{}], level: [{}]", itemId, level);
        log.info("page: [{}], pageSize: [{}]", page, pageSize);

        if (StringUtils.isEmpty(itemId)) {
            return JSONVO.errorMsg(null);
        }

        PagingGridVO pagingGridResult = itemService.queryPagingComment(itemId, level, page, pageSize);
        return JSONVO.ok(pagingGridResult);
    }
}
