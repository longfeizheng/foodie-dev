package com.niocoder.service.impl;

import com.niocoder.mapper.StuMapper;
import com.niocoder.pojo.Stu;
import com.niocoder.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */

@Service
@Transactional
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public Stu getStuInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveStu() {
        Stu stu = Stu.builder()
                .name("jack")
                .age(19)
                .build();
        stuMapper.insert(stu);
    }

    @Override
    public void updateStu(int id) {
        Stu stu = Stu.builder()
                .id(id)
                .name("lucy")
                .age(20)
                .build();
        stuMapper.updateByPrimaryKey(stu);
    }

    @Override
    public void deleteStu(int id) {
        stuMapper.deleteByPrimaryKey(id);
    }
}
