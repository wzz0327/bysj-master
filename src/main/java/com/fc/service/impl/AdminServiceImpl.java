package com.fc.service.impl;

import com.fc.dao.UsersMapper;
import com.fc.entity.Users;
import com.fc.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UsersMapper usersMapper;
    @Override
    public String selectTeacher(Integer pageNum,HttpServletRequest request) {
        List<Users> teacherList = usersMapper.selectByRoleid(1);
        PageHelper.startPage(pageNum,5);
        PageInfo<Users> teachers = new PageInfo<>(teacherList);
        request.setAttribute("list",teacherList);
        request.setAttribute("teachers",teachers);
        return "admin/TeacherList";
    }
}
