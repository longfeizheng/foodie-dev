package com.niocoder.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
@Data
@Table(name = "order_status")
@Accessors(chain = true)
public class OrderStatus  implements Serializable {
    private static final long serialVersionUID = 3896475205114936415L;

    @Id
    private String orderId;

    private Integer orderStatus;

    private Date createdTime;

    private Date payTime;

    private Date deliverTime;

    private Date successTime;

    private Date closeTime;

    private Date commentTime;
}
