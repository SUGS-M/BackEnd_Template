package com.example.backend_template.common.excel;


import com.alibaba.excel.context.AnalysisContext;

import com.alibaba.excel.event.AnalysisEventListener;
import com.example.backend_template.mapper.UserMapper;
import com.example.backend_template.model.User;
import com.example.backend_template.model.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImportListener extends AnalysisEventListener<UserVo> {
    @Autowired
    private UserMapper userMapper;

    //一行一行读取
    @Override
    public void invoke(UserVo userVO, AnalysisContext analysisContext) {
        //调用方法添加数据库
        User user = new User();
        BeanUtils.copyProperties(userVO,user);
        userMapper.insert(user);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }
}