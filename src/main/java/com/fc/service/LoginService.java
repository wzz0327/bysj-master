package com.fc.service;

import com.fc.entity.Users;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;


public interface LoginService {

    String canLogin(String username, String password, HttpServletRequest request);

    String canRegister(Users user,HttpServletRequest request);

    String register(Model model);
}
