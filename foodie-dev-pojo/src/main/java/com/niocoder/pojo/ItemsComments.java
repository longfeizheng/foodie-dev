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
@Table(name = "items_comments")
@Accessors(chain = true)
public class ItemsComments implements Serializable {
    private static final long serialVersionUID = -350321960256110127L;

    @Id
    private String id;

    private String userId;

    private String itemId;

    private String itemName;

    private String itemSpecId;

    private String sepcName;

    private Integer commentLevel;

    private String content;

    private Date createdTime;

    private Date updatedTime;

}
