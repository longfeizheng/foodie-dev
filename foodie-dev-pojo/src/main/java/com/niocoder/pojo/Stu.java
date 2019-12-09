package com.niocoder.pojo;

import lombok.Builder;
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
@Table(name = "stu")
@Accessors(chain = true)
@Builder
public class Stu  implements Serializable {
    private static final long serialVersionUID = -3353939971936582488L;

    @Id
    private Integer id;

    private String name;

    private Integer age;
}
