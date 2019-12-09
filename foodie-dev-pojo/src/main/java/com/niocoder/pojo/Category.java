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
@Table(name = "category")
@Accessors(chain = true)
public class Category implements Serializable {

    private static final long serialVersionUID = -4942376194463861448L;
    @Id
    private Integer id;

    private String name;

    private Integer type;

    private Integer fatherId;

    private String logo;

    private String slogan;

    private String catImage;

    private String bgColor;
}
