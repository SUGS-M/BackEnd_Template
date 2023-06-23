package com.example.backend_template.service;

import com.example.backend_template.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author 18599
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2023-06-23 11:09:08
*/
public interface UserService extends IService<User> {
    /**login*/
    User login(String loginName, String loginPassword, HttpServletRequest request);
    /**导出*/
    void exportData(HttpServletResponse response);
    /**导入*/
    void importData(MultipartFile file);
}
