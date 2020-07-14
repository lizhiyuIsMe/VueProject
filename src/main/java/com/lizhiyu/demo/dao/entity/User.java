package com.lizhiyu.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizhiyu
 * @since 2020-07-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {

    private static final long serialVersionUID=1L;

    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private Long userId;

    private String userName;

    private Integer userAge;

    private String userEmail;

    private Integer flag;

    private Integer version;

    //这样可以指定返回的json格式
//    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
//    private Date date;

}
