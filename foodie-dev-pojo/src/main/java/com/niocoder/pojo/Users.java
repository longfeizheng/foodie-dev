package com.niocoder.pojo;

import lombok.AllArgsConstructor;
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
@Table(name = "users")
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class Users implements Serializable {

    private static final long serialVersionUID = -6238266623970110976L;

    @Id
    private String id;

    private String username;

    private String password;

    private String nickname;

    private String realname;

    private String face;

    private String mobile;

    private String email;

    private Integer sex;

    private Date birthday;

    private Date createdTime;

    private Date updatedTime;

    public Users() {

    }

}
