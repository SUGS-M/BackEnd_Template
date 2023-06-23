package com.example.backend_template.model.vo;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UserVo {
    /**
     * ID
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 用户名
     */
    @ExcelProperty(value = "username")
    private String username;

    /**
     * 密码
     */
    @ExcelProperty(value = "password")
    private String password;
    @ExcelProperty(value = "is_delete")
    private Integer is_delete;

}
