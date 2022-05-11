package com.fc.service;

import com.fc.entity.Users;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;


public interface LoginService {

    String canLogin(String username, String password, HttpServletRequest request);

    String canRegister(Users user,HttpServletRequest request);

    String register(Model model);

    String logout(HttpServletRequest request);

    String tlogout(HttpServletRequest request);

    String alogout(HttpServletRequest request);

    String llogout(HttpServletRequest request);

    String zclogout(HttpServletRequest request);

    String xiugai(Integer userid, String userpwd, HttpServletRequest request);

    String login(HttpServletRequest request);
}
