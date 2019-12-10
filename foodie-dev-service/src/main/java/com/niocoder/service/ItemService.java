package com.niocoder.service;

import com.niocoder.common.PagingGridVO;
import com.niocoder.pojo.Items;
import com.niocoder.pojo.ItemsImg;
import com.niocoder.pojo.ItemsParam;
import com.niocoder.pojo.ItemsSpec;
import com.niocoder.pojo.vo.CommentLevelCountVO;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
public interface ItemService {
    /**
     * 根据商品Id查询详情
     *
     * @param itemId 商品Id
     * @return 商品
     */
    Items queryItemById(String itemId);

    /**
     * 根据商品Id查询商品图片列表
     *
     * @param itemId 商品Id
     * @return 商品图片
     */
    List<ItemsImg> queryItemImageList(String itemId);

    /**
     * 根据商品Id查询商品规格
     *
     * @param itemId 商品Id
     * @return 商品规格
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品Id查询商品参数
     *
     * @param itemId 商品Id
     * @return 商品参数
     */
    ItemsParam queryItemParam(String itemId);

    /**
     * 根据商品Id查询商品评价
     *
     * @param itemId 商品Id
     * @return 商品评价
     */
    CommentLevelCountVO queryCommentCount(String itemId);

    /**
     * 根据商品Id查询商品的评价（分页）
     *
     * @param itemId 商品Id
     * @param level 等级
     * @return 商品评价
     */
    PagingGridVO queryPagingComment(String itemId, int level, Integer page, Integer pageSize);
}
