package com.niocoder.mapper;

import com.niocoder.APIApplication;
import com.niocoder.pojo.Users;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = APIApplication.class)
@Slf4j
public class UsersMapperTest {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void selectTest() {
        Users users = usersMapper.selectByPrimaryKey("1908017YR51G1XWH");
        log.info("users:{}", users);
    }
}
