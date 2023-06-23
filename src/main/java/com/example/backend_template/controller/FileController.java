package com.example.backend_template.controller;



import com.example.backend_template.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletResponse;

@RestController
public class FileController {
    @Resource
    private UserService userService;

    @PostMapping("/exportData")
    public void exportData(HttpServletResponse response){
        userService.exportData(response);
    }


    @PostMapping("importData")
    public void importData(MultipartFile file) {
        userService.importData(file);
    }


}

