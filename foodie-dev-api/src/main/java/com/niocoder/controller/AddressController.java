package com.niocoder.controller;

import com.niocoder.common.JSONVO;
import com.niocoder.pojo.query.AddressQuery;
import com.niocoder.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Api(value = "地址相关", tags = {"地址相关的api接口"})
@RestController
@RequestMapping("/address")
@Slf4j
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 用户在确认订单页面，可以针对收货地址做如下操作：
     * 1. 查询用户的所有收货地址列表
     * 2. 新增收货地址
     * 3. 删除收货地址
     * 4. 修改收货地址
     * 5. 设置默认地址
     */
    @ApiOperation(value = "根据用户id查询收货地址列表", notes = "根据用户id查询收货地址列表", httpMethod = "POST")
    @PostMapping("/list")
    public JSONVO list(@RequestParam String userId) {
        log.info("userId: [{}]", userId);

        if (StringUtils.isEmpty(userId)) {
            return JSONVO.errorMsg("");
        }

        return JSONVO.ok(addressService.queryAll(userId));
    }

    /**
     * 新增收货地址
     */
    @ApiOperation(value = "用户新增地址", notes = "用户新增地址", httpMethod = "POST")
    @PostMapping("/add")
    public JSONVO add(@RequestBody AddressQuery addressQuery) {
        log.info("addressQuery: [{}]", addressQuery);

        addressService.addNewUserAddress(addressQuery);
        return JSONVO.ok();
    }

    /**
     * 删除收货地址
     */
    @ApiOperation(value = "用户删除地址", notes = "用户删除地址", httpMethod = "POST")
    @PostMapping("/delete")
    public JSONVO delete(@RequestParam String userId, @RequestParam String addressId) {
        log.info("userId: [{}], addressId: [{}]", userId, addressId);

        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(addressId)) {
            return JSONVO.errorMsg("");
        }

        addressService.deleteUserAddress(addressId);
        return JSONVO.ok();
    }

    /**
     * 设置默认收货地址
     */
    @ApiOperation(value = "用户设置默认地址", notes = "用户设置默认地址", httpMethod = "POST")
    @PostMapping("/setDefalut")
    public JSONVO setDefault(@RequestParam String userId, @RequestParam String addressId) {
        log.info("userId: [{}], addressId: [{}]", userId, addressId);

        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(addressId)) {
            return JSONVO.errorMsg("");
        }

        addressService.updateUserAddressAsDefault(userId, addressId);
        return JSONVO.ok();
    }
}
