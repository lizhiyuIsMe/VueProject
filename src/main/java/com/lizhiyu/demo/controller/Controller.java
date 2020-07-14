package com.lizhiyu.demo.controller;


import com.lizhiyu.demo.dao.entity.User;
import com.lizhiyu.demo.service.IUserService;
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
public class Controller {


    @Autowired
    private IUserService userServiceImpl;

    public List<User>  queryAllStudent(){
        List<User> list = userServiceImpl.list();
        return  list;
    }
}

