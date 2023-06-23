package com.example.backend_template.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backend_template.common.BaseResponse;
import com.example.backend_template.common.ResultUtils;
import com.example.backend_template.common.request.LoginRequest;
import com.example.backend_template.common.request.PageRequest;
import com.example.backend_template.model.User;
import com.example.backend_template.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public User login(LoginRequest loginRequest, HttpServletRequest request){
        if(loginRequest == null){
            System.out.println("不能为空");
        }
        String loginName = loginRequest.getUsername();
        String loginPassword = loginRequest.getPassword();
        User user = userService.login(loginName,loginPassword,request);
        return user;
    }

    /**增*/
    @PostMapping("/add")
    public BaseResponse<Boolean> addUser(@RequestBody  User user){
        //userService.save(user)返回Boolean结果
        return ResultUtils.success(userService.save(user));
    }
    /**删*/
    @DeleteMapping("/delete/{id}")
    public BaseResponse<Boolean> deleteUser(@PathVariable Long id){
        return ResultUtils.success(userService.removeById(id));
    }
    /**改*/
    @PostMapping("/update")
    public BaseResponse<Boolean> updateUser(@RequestBody  User user){
        return ResultUtils.success(userService.updateById(user));
    }
    /**查*/
    @PostMapping("/list")
    public BaseResponse<List<User>> listUser(){
        return ResultUtils.success(userService.list());
    }
//    @ApiOperation("这是啥，都是结合分页查询")
//    @PostMapping("/listbywrapper")
//    public BaseResponse<List<User>> listUserByWrapper(){
//        QueryWrapper queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username","uer003");
//        return ResultUtils.success(userService.list(queryWrapper));
//    }
    @PostMapping("/listbypage")
    public BaseResponse<Page<User>> listUserByPage(PageRequest pageRequest){
        Page<User> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        return ResultUtils.success(userService.page(page));
    }



}
