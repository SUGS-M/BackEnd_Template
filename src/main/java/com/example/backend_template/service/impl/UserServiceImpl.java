package com.example.backend_template.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend_template.common.ErrorCode;
import com.example.backend_template.common.excel.ImportListener;
import com.example.backend_template.exception.BusinessException;
import com.example.backend_template.model.User;
import com.example.backend_template.model.vo.UserVo;
import com.example.backend_template.service.UserService;
import com.example.backend_template.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
* @author 18599
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2023-06-23 11:09:08
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;

    @Resource
    private ImportListener importListener;

    @Override
    public User login(String loginName, String loginPassword, HttpServletRequest request) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",loginName);
        queryWrapper.eq("password",loginPassword);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null){
            //return ;返回类型确定了，不能再return其他类型。抛异常！！！
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"账号不存在或密码错误");
        }
        return user;
    }

    @Override
    public void exportData(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("用户", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename="+ fileName + ".xlsx");
            List<User> userList = baseMapper.selectList(null);
            List<UserVo> userVoList = new ArrayList<>(userList.size());
            for(User user : userList) {
                UserVo userVo = new UserVo();
                BeanUtils.copyProperties(user,userVo);
                userVoList.add(userVo);
            }
            EasyExcel.write(response.getOutputStream(), UserVo.class).sheet("用户表").doWrite(userVoList);
            //EasyExcel.write(response.getOutputStream(), UserVO.class).sheet("课程分类").doWrite(userVoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //导入
    @Override
    public void importData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(),
                    UserVo.class,importListener).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




