package com.niocoder.pojo.vo;

import com.niocoder.pojo.Items;
import com.niocoder.pojo.ItemsImg;
import com.niocoder.pojo.ItemsParam;
import com.niocoder.pojo.ItemsSpec;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Builder
@Data
public class ItemInfoVO {
    /**
     * 商品
     */
    private Items item;

    /**
     * 商品图片
     */
    private List<ItemsImg> itemImgList;

    /**
     * 商品规格
     */
    private List<ItemsSpec> itemSpecList;

    /**
     * 商品参数
     */
    private ItemsParam itemParams;
}
