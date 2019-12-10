package com.niocoder.common;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Data
@Builder
public class PagingGridVO {
    /**
     * 当前页号
     */
    private Integer page;

    /**
     * 总页数
     */
    private Integer total;

    /**
     * 总记录数
     */
    private Long record;

    /**
     * 每行显示的内容
     */
    private List<?> rows;
}

