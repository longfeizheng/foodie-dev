package com.niocoder.common.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {
}