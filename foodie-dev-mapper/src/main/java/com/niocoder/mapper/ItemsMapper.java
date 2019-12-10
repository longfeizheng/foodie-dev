package com.niocoder.mapper;

import com.niocoder.common.mybatis.TkMapper;
import com.niocoder.pojo.Items;
import com.niocoder.pojo.vo.SearchItemsVO;
import com.niocoder.pojo.vo.ShopCartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
public interface ItemsMapper extends TkMapper<Items> {

    /**
     * 查询商品列表
     */
    List<SearchItemsVO> selectItem(@Param("paramsMap") Map<String, Object> map);

    /**
     * 通过三级分类，查询商品列表
     */
    List<SearchItemsVO> selectItemByThirdCategory(@Param("paramsMap") Map<String, Object> map);

    /**
     * 根据规格ids查询最新的购物车中的商品数据（用于刷新渲染购物车中的商品数据）
     */
    List<ShopCartVO> selectItemBySpecIdList(@Param("specIdList")List<String> specIdList);

}
