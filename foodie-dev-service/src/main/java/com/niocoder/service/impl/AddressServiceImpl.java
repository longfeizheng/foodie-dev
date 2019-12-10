package com.niocoder.service.impl;

import com.niocoder.common.IdWorker;
import com.niocoder.enums.YesNoEnum;
import com.niocoder.mapper.UserAddressMapper;
import com.niocoder.pojo.UserAddress;
import com.niocoder.pojo.query.AddressQuery;
import com.niocoder.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public List<UserAddress> queryAll(String userId) {
        return userAddressMapper.select(new UserAddress().setUserId(userId));
    }

    @Override
    public void addNewUserAddress(AddressQuery addressQuery) {
// 判断当前用户是否存在地址，如果没有，则新增为“默认地址”
        int isDefault = 0;
        List<UserAddress> userAddressList = queryAll(addressQuery.getUserId());
        if (CollectionUtils.isEmpty(userAddressList)) {
            isDefault = 1;
        }

        // 保存地址到数据库
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(addressQuery, userAddress);

        userAddress.setId(String.valueOf(idWorker.nextId()));
        userAddress.setIsDefault(isDefault);
        userAddress.setCreatedTime(new Date());
        userAddress.setUpdatedTime(new Date());
        userAddressMapper.insert(userAddress);
    }

    @Override
    public void deleteUserAddress(String addressId) {
        userAddressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public void updateUserAddressAsDefault(String userId, String addressId) {
        List<UserAddress> userAddressList = userAddressMapper.select(UserAddress.builder().userId(userId).build());
        for (UserAddress userAddress : userAddressList) {
            userAddress.setIsDefault(YesNoEnum.NO.getType());
            userAddressMapper.updateByPrimaryKeySelective(userAddress);
        }

        // 根据地址Id，修改其记录为默认的地址
        UserAddress userAddress = UserAddress.builder()
                .id(addressId)
                .userId(userId)
                .isDefault(YesNoEnum.YES.getType())
                .build();
        userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }

    @Override
    public UserAddress queryUserAddress(String userId, String addressId) {
        return userAddressMapper.selectByPrimaryKey(addressId);
    }
}
