package com.niocoder.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.niocoder.common.DesensitizationUtil;
import com.niocoder.common.PagingGridVO;
import com.niocoder.converter.PageInfo2PagingGridResultConverter;
import com.niocoder.enums.CommentLevelEnum;
import com.niocoder.mapper.*;
import com.niocoder.pojo.*;
import com.niocoder.pojo.vo.CommentLevelCountVO;
import com.niocoder.pojo.vo.ItemCommentVO;
import com.niocoder.pojo.vo.ShopCartVO;
import com.niocoder.service.ItemService;
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
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemsImgMapper itemsImgMapper;
    @Autowired
    private ItemsSpecMapper itemsSpecMapper;
    @Autowired
    private ItemsParamMapper itemsParamMapper;
    @Autowired
    private ItemsCommentsMapper itemsCommentsMapper;

    @Override
    public Items queryItemById(String itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public List<ItemsImg> queryItemImageList(String itemId) {
        return itemsImgMapper.select(new ItemsImg().setItemId(itemId));
    }

    @Override
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        return itemsSpecMapper.select(new ItemsSpec().setItemId(itemId));
    }

    @Override
    public ItemsParam queryItemParam(String itemId) {
        return itemsParamMapper.selectOne(new ItemsParam().setItemId(itemId));
    }

    @Override
    public CommentLevelCountVO queryCommentCount(String itemId) {
        int goodCount = selectCommentCount(itemId, CommentLevelEnum.GOOD.getType());
        int normalCount = selectCommentCount(itemId, CommentLevelEnum.NORMAL.getType());
        int badCount = selectCommentCount(itemId, CommentLevelEnum.BAD.getType());

        return CommentLevelCountVO.builder()
                .totalCounts(goodCount + normalCount + badCount)
                .goodCounts(goodCount)
                .normalCounts(normalCount)
                .badCounts(badCount)
                .build();
    }

    @Override
    public PagingGridVO queryPagingComment(String itemId, int level, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);
        map.put("level", level);

        // page：第几页；pageSize：每页显示条数
        PageHelper.startPage(page, pageSize);
        List<ItemCommentVO> itemCommentVOList = itemsCommentsMapper.selectItemComment(map);

        // 昵称脱敏
        for (ItemCommentVO itemCommentVO : itemCommentVOList) {
            itemCommentVO.setNickname(DesensitizationUtil.commonDisplay(itemCommentVO.getNickname()));
        }
        return PageInfo2PagingGridResultConverter.convert(itemCommentVOList, page);
    }

    @Override
    public PagingGridVO queryItem(String keyword, String sort, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("keyword", keyword);
        map.put("sort", sort);

        PageHelper.startPage(page, pageSize);
        return PageInfo2PagingGridResultConverter.convert(itemsMapper.selectItem(map), page);
    }

    @Override
    public PagingGridVO queryItem(Integer categoryId, String sort, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", categoryId);
        map.put("sort", sort);

        PageHelper.startPage(page, pageSize);
        return PageInfo2PagingGridResultConverter.convert(itemsMapper.selectItemByThirdCategory(map), page);
    }

    @Override
    public List<ShopCartVO> queryItemsBySpecIds(String specIds) {
        String[] idArr = specIds.split(",");
        List<String> specIdList = Lists.newArrayList(idArr);

        return itemsMapper.selectItemBySpecIdList(specIdList);
    }

    @Override
    public ItemsSpec queryItemSpecById(String specId) {
        return itemsSpecMapper.selectByPrimaryKey(specId);
    }

    @Override
    public ItemsImg queryItemMainImageById(String itemId) {
        return itemsImgMapper.selectOne(new ItemsImg().setItemId(itemId));
    }

    int selectCommentCount(String itemId, int level) {
        return itemsCommentsMapper.selectCount(new ItemsComments().setItemId(itemId).setCommentLevel(level));
    }
}
