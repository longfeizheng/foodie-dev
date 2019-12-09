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
@Table(name = "items_param")
@Accessors(chain = true)
public class ItemsParam  implements Serializable {
    private static final long serialVersionUID = 7469645555451553198L;

    @Id
    private String id;

    private String itemId;

    private String producPlace;

    private String footPeriod;

    private String brand;

    private String factoryName;

    private String factoryAddress;

    private String packagingMethod;

    private String weight;

    private String storageMethod;

    private String eatMethod;

    private Date createdTime;

    private Date updatedTime;

}
