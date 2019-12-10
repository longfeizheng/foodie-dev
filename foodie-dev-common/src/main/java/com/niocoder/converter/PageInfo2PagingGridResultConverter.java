package com.niocoder.converter;

import com.github.pagehelper.PageInfo;
import com.niocoder.common.PagingGridVO;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
public class PageInfo2PagingGridResultConverter {

    /**
     * 转换
     */
    public static PagingGridVO convert(List<?> list, int page) {
        PageInfo<?> pageInfo = new PageInfo<>(list);

        return PagingGridVO.builder()
                .page(page)
                .rows(list)
                .total(pageInfo.getPages())
                .record(pageInfo.getTotal())
                .build();
    }
}
