package com.niocoder.controller;

import com.niocoder.common.JSONVO;
import com.niocoder.enums.PayMethodEnum;
import com.niocoder.enums.ResultEnum;
import com.niocoder.pojo.query.SubmitOrderQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Api(value = "订单相关", tags = {"订单相关的api接口"})
@RequestMapping("/orders")
@RestController
@Slf4j
public class OrderController {
    @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
    @PostMapping("/create")
    public JSONVO create(@RequestBody SubmitOrderQuery submitOrderQuery) {
        log.info("submitOrderQuery: [{}]", submitOrderQuery);

        // 判断支付方式
        Integer payMethod = submitOrderQuery.getPayMethod();
        if (Objects.equals(payMethod, PayMethodEnum.WEIXIN.getType())
                && Objects.equals(payMethod, PayMethodEnum.ALIPAY.getType())) {
            return JSONVO.errorMsg(ResultEnum.PAY_METHOD_NOT_SUPPORTED.getMessage());
        }

        return JSONVO.ok();
    }
}
