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
@Table(name = "carousel")
@Accessors(chain = true)
public class Carousel implements Serializable {

    private static final long serialVersionUID = 3813020783537610896L;
    @Id
    private String id;

    private String imageUrl;

    private String backgroundColor;

    private String itemId;

    private String catId;

    private Integer type;

    private Integer sort;

    private Integer isShow;

    private Date createTime;

    private Date updateTime;

}
