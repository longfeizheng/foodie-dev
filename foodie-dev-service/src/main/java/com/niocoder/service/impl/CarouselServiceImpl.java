package com.niocoder.service.impl;

import com.niocoder.mapper.CarouselMapper;
import com.niocoder.pojo.Carousel;
import com.niocoder.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAll(Integer type) {
        return carouselMapper.select(new Carousel().setSort(type));
    }
}
