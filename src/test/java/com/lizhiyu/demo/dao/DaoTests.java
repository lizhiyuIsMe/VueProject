package com.lizhiyu.demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lizhiyu.demo.dao.entity.User;
import com.lizhiyu.demo.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

@SpringBootTest
class DaoTests {


    @Autowired
    private UserMapper userMapper;


    @Test
    void contextLoads() {



    }

    @Test
    public void  testUpdate(){
            User u=new User();
            u.setUserName("lizhiyu");
            u.setUserAge(0);
            u.setUserEmail("122@163.com");
            u.setUpdateTime(new Date());
            int insert = userMapper.insert(u);


            User user = userMapper.selectById("1281899806444224514");
            user.setUserAge(10);
            userMapper.updateById(user);
            System.out.println(user.getVersion());

            user.setUserAge(user.getUserAge()+1);
            userMapper.updateById(user);
            System.out.println(user.getVersion());


            user.setUserAge(user.getUserAge()+1);
            //user.setUpdateTime(new Date());
            userMapper.updateById(user);
            System.out.println(user.getVersion());

    }

    @Test
    public void  testFind(){
        List<User> users = userMapper.selectList(null);
        List<User> users1 = userMapper.selectBatchIds(Arrays.asList("1281899806444224514", 2));
        users1.forEach(System.out::println);
        Map map=new HashMap();
        map.put("user_name", "lizhiyu");
        map.put("user_age", 12);
        List list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }

    @Test
    public void  selectOne(){
        //查询数据多一条则报错
        User user = userMapper.selectOne(null);
        System.out.println(user);
    }
    @Test
    public void testSelectPage(){
        //QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //只查询这两列
        //queryWrapper.select("user_id","user_name");
        /*第一页 每页5条数据*/
        Page<User> page=new Page<>(1,5);
        Page<User> userPage = userMapper.selectPage(page, null);
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);
        userPage.getCurrent();//当前页码
        userPage.getTotal();//总共多少条
        userPage.getPages();//总页数
        userPage.getSize();//每页记录数
        userPage.hasNext(); //是否有下一页
        userPage.hasPrevious(); //是否有上一页
    }

    @Test
    public void testSelectPageByMap(){

        /*queryWrapper使用方法 https://mp.baomidou.com/guide/wrapper.html#notin*/
        QueryWrapper<User> queryWrapper2=new QueryWrapper<>();
        queryWrapper2.select("user_id","user_name");


        /*第一页 每页5条数据*/
        Page<Map<String,Object>> page=new Page<>(1,5);
        Page<Map<String,Object>>  mapPage = userMapper.selectMapsPage(page, queryWrapper2);

        /*返回类型是map*/
        List<Map<String,Object>> records = mapPage.getRecords();
        records.forEach(System.out::println);
        mapPage.getCurrent();//当前页码
        mapPage.getTotal();//总共多少条
        mapPage.getPages();//总页数
        mapPage.getSize();//每页记录数
        mapPage.hasNext(); //是否有下一页
        mapPage.hasPrevious(); //是否有上一页
    }


    @Test
    public void testDeleteById(){
        int i = userMapper.deleteById("132");
    }


    @Test
    public void testDeleteByBathIds(){
        int i = userMapper.deleteBatchIds(Arrays.asList("1281903925548576770","1281908284655214594"));
    }

    @Test
    public void testDeleteByMap(){
        Map map=new HashMap();
        map.put("user_id", "1281908284655214594");
        int i = userMapper.deleteByMap(map);
    }
}
