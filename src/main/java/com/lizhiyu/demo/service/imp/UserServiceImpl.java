package com.lizhiyu.demo.service.imp;

import com.lizhiyu.demo.dao.entity.User;
import com.lizhiyu.demo.dao.mapper.UserMapper;
import com.lizhiyu.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizhiyu
 * @since 2020-07-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
