package com.fc.service;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {
    String selectTeacher(Integer pageNum,HttpServletRequest request);
}
