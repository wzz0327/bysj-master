package com.fc.controller;

import com.fc.entity.Users;
import com.fc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("login")
    public String login(){
        return "student/login";
    }

    @PostMapping("CanLogin")
    public String canLogin(@RequestParam String username,
                             @RequestParam String userpwd,
                           HttpServletRequest request){

        return loginService.canLogin(username, userpwd,request);
    }

    @GetMapping("register")
    public String register(Model model){
        return loginService.register(model);
    }

    @PostMapping("CanRegister")
    public String canRegister(Users user,
                              HttpServletRequest request){
        return loginService.canRegister(user,request);
    }
}
