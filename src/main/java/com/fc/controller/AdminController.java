package com.fc.controller;

import com.fc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    AdminService adminService;


    @GetMapping("AdminManage")
    public String adminManage() {
        return "admin/AdminManage";
    }

    @GetMapping("AdminTeacherManage")
    public String adminCourseManage(@RequestParam(defaultValue = "1") Integer pageNum,HttpServletRequest request) {
        return adminService.selectTeacher(pageNum,request);
    }

}


