package com.lizhiyu.demo.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //当前项目目录
        String projectPath = System.getProperty("user.dir");
        //输出路径
        gc.setOutputDir(projectPath + "/src/main/java");
        //作者名字
        gc.setAuthor("lizhiyu");
        //生成的实体类的id的主键策略，也就是属性上的注解
        gc.setIdType(IdType.ASSIGN_ID);
        //生成后是否打开资源管理器
        gc.setOpen(false);
        //重新生成文件，是否覆盖源文件
        gc.setFileOverride(true);
        //生成实体类中日期类型
        gc.setDateType(DateType.ONLY_DATE);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //&useUnicode=true&useSSL=false&characterEncoding=utf8
        dsc.setUrl("jdbc:mysql://192.168.43.116:3306/project?serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //输出文件所在的父目录
        pc.setParent("");
        pc.setEntity("com.lizhiyu.demo.dao.entity");
        pc.setMapper("com.lizhiyu.demo.dao.mapper");
        pc.setXml("com.lizhiyu.demo.dao.mapper.xml");
        pc.setController("com.lizhiyu.demo.controller");
        pc.setService("com.lizhiyu.demo.service");
        pc.setServiceImpl("com.lizhiyu.demo.service.imp");
        mpg.setPackageInfo(pc);



        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体类  数据库下划线转换成驼峰形式
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库列映射到实体类  数据库下划线转换成驼峰形式
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //是否使用lombok
        strategy.setEntityLombokModel(true);
        //將表名替换成类名时，表名前缀名相同则删除
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        //controller中的Controller注解替换成 restController
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true); //url驼峰转连接字符

        //生成代码要继承的类
        strategy.setSuperEntityClass("com.lizhiyu.demo.dao.entity.BaseEntity");
        //生成代码要继承的类中有哪些字段,在生成类的同时不生成这些字段,因为父类中已经有了
        strategy.setSuperEntityColumns("create_time","update_time");


        mpg.setStrategy(strategy);
        mpg.execute();
    }

}