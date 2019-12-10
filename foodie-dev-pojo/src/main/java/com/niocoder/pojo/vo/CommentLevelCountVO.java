package com.niocoder.pojo.vo;

import lombok.Builder;
import lombok.Data;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Data
@Builder
public class CommentLevelCountVO {
    /**
     * 总评价数
     */
    private Integer totalCounts;

    /**
     * 好评数
     */
    private Integer goodCounts;

    /**
     * 中评数
     */
    private Integer normalCounts;

    /**
     * 差评数
     */
    private Integer badCounts;
}