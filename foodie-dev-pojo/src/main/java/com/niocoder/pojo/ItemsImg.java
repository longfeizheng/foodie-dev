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
@Table(name = "items_img")
@Accessors(chain = true)
public class ItemsImg  implements Serializable {
    private static final long serialVersionUID = -4132171824858759600L;

    @Id
    private String id;

    private String itemId;

    private String url;

    private Integer sort;

    private Integer isMain;

    private Date createdTime;

    private Date updatedTime;
}
