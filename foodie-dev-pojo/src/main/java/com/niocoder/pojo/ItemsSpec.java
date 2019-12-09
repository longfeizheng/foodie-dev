package com.niocoder.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
@Data
@Table(name = "items_spec")
@Accessors(chain = true)
public class ItemsSpec  implements Serializable {
    private static final long serialVersionUID = 3636502046903107642L;

    @Id
    private String id;

    private String itemId;

    private String name;

    private Integer stock;

    private BigDecimal discounts;

    private Integer priceDiscount;

    private Integer priceNormal;

    private Date createdTime;

    private Date updatedTime;
}
