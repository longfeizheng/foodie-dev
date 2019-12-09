package com.niocoder.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
@Data
@Table(name = "order_Items")
@Accessors(chain = true)
public class OrderItems  implements Serializable {
    private static final long serialVersionUID = -4620611461195375302L;

    @Id
    private String id;

    private String orderId;

    private String itemId;

    private String itemImg;

    private String itemName;

    private String itemSpecId;

    private String itemSpecName;

    private Integer price;

    private Integer buyCounts;

}
