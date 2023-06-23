
1.初始化项目
    ①Spring Initializr[JDK|SpingBoot|依赖]，②application.yml[port + datasource/mvc]，③删除多余文件，④数据库[sql文件夹 + user测试表]，⑤结构搭建[model/mapper/service/controller/config/common]
2.生成基础代码
    MybatisX代码->mybatis-plus依赖  ||  @Mapper注解/@TableLogic注解
3.辅组工具
    ①统一返回接口[common] ②swagger[yml配置,knife4j/swagger依赖,swagger配置类]
4.基础接口[参数注解+内置函数]+测试+分页[需要额外配置类]
    isDelete为什么不行呢[???]
    [一直问题！]isDelete删除，但是代码还是原来生成的，会报错
    -----
    QueryWrapper[如何测试!][???]
    -----
    >>>数据库/model/XML改成is_delete
    >>>逻辑删除：删除测试时，直接逻辑删除[就加了注解]
    >>>分页查询：[MybatisPlusConfig配置类+page请求类]

[//]: # (swagger接口文档、统一返回、CRUD、逻辑删除  | | login/regist、文件上传/下载、图片  | | [封装类+请求类优化]、)
5.login/regist
    >>>登录：判空 + QueryWrapper[username & password]
    >>>异常类[不能return不同数据，改成throw new BusinessException]
    >>>登录：添加逻辑+若干判断
6.文件上传/下载
    easyExcel依赖[maven:cannot reconnect问题],UserVo[安全类+@ExcelProperty],excel监听组件，
    >>>Failed to execute 'createObjectURL' on 'URL': Overload resolution failed.

7.图片