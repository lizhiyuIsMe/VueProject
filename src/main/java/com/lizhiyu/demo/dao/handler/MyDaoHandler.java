package com.lizhiyu.demo.dao.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyDaoHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        /*在更新所有表的时候找到这个属性的字段进行更新值*/
        this.setFieldValByName("createTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
