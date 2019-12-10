package com.niocoder.pojo;

import lombok.Builder;
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
@Table(name = "orders")
@Accessors(chain = true)
@Builder
public class Orders implements Serializable {
    private static final long serialVersionUID = 3365850138006839129L;

    @Id
    private String id;

    private String userId;

    private String receiverName;

    private String receiverMobile;

    private String receiverAddress;

    private Integer totalAmount;

    private Integer realPayAmount;

    private Integer postAmount;

    private Integer payMethod;

    private String leftMsg;

    private String extand;

    private Integer isComment;

    private Integer isDelete;

    private Date createdTime;

    private Date updatedTime;

    public Orders() {

    }
}
