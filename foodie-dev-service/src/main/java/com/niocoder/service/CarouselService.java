package com.niocoder.service;

import com.niocoder.pojo.Carousel;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
public interface CarouselService {

    List<Carousel> queryAll(Integer type);
}
