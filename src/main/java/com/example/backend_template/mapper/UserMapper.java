package com.example.backend_template.mapper;

import com.example.backend_template.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 18599
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2023-06-23 11:09:08
* @Entity com.example.backend_template.model.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




