package com.lizhiyu.demo.controller.user;


import com.lizhiyu.demo.dao.entity.User;
import com.lizhiyu.demo.service.IUserService;
import com.lizhiyu.demo.util.exception.ExceptionUtils;
import com.lizhiyu.demo.vo.base.R;
import com.lizhiyu.demo.vo.user.UserQueryVo;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizhiyu
 * @since 2020-07-11
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userServiceImpl;

    @GetMapping("/queryUser")
    public R queryAllStudent(@ApiParam("用戶列表查询对象") UserQueryVo userQueryVo){
            return R.ok().data("12","12").data("22","22");
    }
}

