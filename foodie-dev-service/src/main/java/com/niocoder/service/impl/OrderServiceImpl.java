package com.niocoder.service.impl;

import com.niocoder.common.IdWorker;
import com.niocoder.enums.YesNoEnum;
import com.niocoder.mapper.OrderItemsMapper;
import com.niocoder.mapper.OrdersMapper;
import com.niocoder.pojo.*;
import com.niocoder.pojo.query.SubmitOrderQuery;
import com.niocoder.service.AddressService;
import com.niocoder.service.ItemService;
import com.niocoder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zhenglongfei 2019-12-10.
 *
 * @VERSION 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private AddressService addressService;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private ItemService itemService;
    @Autowired
    private OrderItemsMapper orderItemsMapper;

    @Override
    public void createOrder(SubmitOrderQuery submitOrderQuery) {
        String userId = submitOrderQuery.getUserId();
        String addressId = submitOrderQuery.getAddressId();
        String itemSpecIds = submitOrderQuery.getItemSpecIds();
        Integer payMethod = submitOrderQuery.getPayMethod();
        String leftMsg = submitOrderQuery.getLeftMsg();
        // 包邮费用设置为0
        int postAmount = 0;

        // 用户订单上的地址
        UserAddress userAddress = addressService.queryUserAddress(userId, addressId);

        // 新订单数据保存
        Orders orders = Orders.builder()
                .id(String.valueOf(idWorker.nextId()))
                .userId(userId)
                .receiverName(userAddress.getReceiver())
                .receiverMobile(userAddress.getMobile())
                .receiverAddress(userAddress.getProvince() + " "
                        + userAddress.getCity() + " "
                        + userAddress.getDistrict() + " "
                        + userAddress.getDetail())
                .postAmount(postAmount)
                .payMethod(payMethod)
                .leftMsg(leftMsg)
                .isComment(YesNoEnum.NO.getType())
                .isDelete(YesNoEnum.NO.getType())
                .createdTime(new Date())
                .updatedTime(new Date())
                .build();
        // 循环根据itemSpecIds保存订单商品信息表
        // 商品原价累积
        int totalAmount = 0;
        // 优惠后的实际支付价格累计
        int realPayAmount = 0;
        for (String itemSpecId : itemSpecIds.split(",")) {
            // todo 整合redis后，商品购买的数量重新从redis的购物车中获取
            int buyCount = 1;

            // 根据规格id，查询规格的具体信息，主要获取价格
            ItemsSpec itemsSpec = itemService.queryItemSpecById(itemSpecId);
            totalAmount += itemsSpec.getPriceNormal() * buyCount;
            realPayAmount += itemsSpec.getPriceDiscount() * buyCount;

            // 根据商品Id，获取商品信息以及商品图片
            String itemId = itemsSpec.getItemId();
            Items items = itemService.queryItemById(itemId);
            ItemsImg itemsImg = itemService.queryItemMainImageById(itemId);

            // 循环保存子订单数据到数据库
            OrderItems orderItems = OrderItems.builder()
                    .id(String.valueOf(idWorker.nextId()))
                    .orderId(orders.getId())
                    .itemId(itemId)
                    .itemName(items.getItemName())
                    .itemImg(itemsImg == null ? "" : itemsImg.getUrl())
                    .buyCounts(buyCount)
                    .itemSpecId(itemSpecId)
                    .itemSpecName(itemsSpec.getName())
                    .price(itemsSpec.getPriceDiscount())
                    .build();
            orderItemsMapper.insert(orderItems);
        }

        orders.setTotalAmount(totalAmount);
        orders.setRealPayAmount(realPayAmount);
        ordersMapper.insert(orders);
        // 保存订单状态表
    }
}
