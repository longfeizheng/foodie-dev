package com.niocoder.mapper;

import com.niocoder.common.mybatis.TkMapper;
import com.niocoder.pojo.ItemsComments;
import com.niocoder.pojo.vo.ItemCommentVO;

import java.util.List;
import java.util.Map;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
public interface ItemsCommentsMapper extends TkMapper<ItemsComments> {

    List<ItemCommentVO> selectItemComment(Map<String, Object> map);
}
