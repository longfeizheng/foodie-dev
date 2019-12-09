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
@Table(name = "items")
@Accessors(chain = true)
public class Items implements Serializable {
    private static final long serialVersionUID = 8657866389572520322L;

    @Id
    private String id;

    private String itemName;

    private Integer catId;

    private Integer rootCatId;

    private Integer sellCounts;

    private Integer onOffStatus;

    private Date createdTime;

    private Date updatedTime;

    private String content;
}
