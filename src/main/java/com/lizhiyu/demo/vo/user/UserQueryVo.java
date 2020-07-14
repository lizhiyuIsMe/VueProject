package com.lizhiyu.demo.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lizhiyu
 * @since 2020/4/1
 */
@ApiModel("User查询对象")
@Data
public class UserQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用戶名")
    private String name;


}