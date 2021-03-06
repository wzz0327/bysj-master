package com.fc.service.impl;

import com.fc.dao.PjclassMapper;
import com.fc.dao.UsersMapper;
import com.fc.entity.Pjclass;
import com.fc.entity.Users;
import com.fc.entity.UsersExample;
import com.fc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PjclassMapper pjclassMapper;
    @Override
    public String canLogin(String username,
                           String password,
                           HttpServletRequest request) {

        HttpSession session=request.getSession();

        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Users> users = usersMapper.selectByExample(example);

        if (users.size()>0){
            Users user = users.get(0);

            session.setAttribute("user",user);
            session.setMaxInactiveInterval(30 * 60);
            session.setAttribute("classid",user.getClassid());
            if (user.getUserpwd().equals(password)){
                if (user.getRoleid().equals(1)){
                    session.setAttribute("Tclassid",user.getClassid());
                    session.setAttribute("roleid",user.getRoleid());
                    return "teacher/manage";
                }else if (user.getRoleid().equals(2)){
                    session.setAttribute("userid",user.getUserid());
                    session.setAttribute("roleid",user.getRoleid());
                    return "student/StuMan";
                }else if (user.getRoleid().equals(3)){
                    session.setAttribute("roleid",user.getRoleid());
                    return "admin/AdminManage";
                }
            }else {
                String errorInfo = "?????????????????????";
                session.setAttribute("errorInfo",errorInfo);
            }
        }

        return "student/login";
    }

    @Override
    public String canRegister(Users user,HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Users> users;
        Map<String ,Object> map=new HashMap<>();
        map.put("code",-1);
        map.put("message","????????????");
        map.put("success",false);

        if (user.getUsername()!=null || !user.getUsername().equals("")){
            UsersExample example = new UsersExample();
            UsersExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(user.getUsername());
            users = usersMapper.selectByExample(example);
        }else {
            String cz="?????????????????????";
            session.setAttribute("cz",cz);
            return "redirect:/register";
        }

        if (users.size()>0){
            map.put("message","????????????????????????");
            request.setAttribute("map",map);
            return "redirect:/register";
        }else {
            if (user.getUserpwd().equals("") || user.getTruename().equals("")){
                String wk="?????????????????????????????????";
                session.setAttribute("wk",wk);
                return "redirect:/register";
            }else {
                int insert = usersMapper.insert(user);
                if (insert>0){
                    map.put("code",200);
                    map.put("message","????????????");
                    map.put("success",true);
                    request.setAttribute("map",map);
                    String cg="????????????,?????????";
                    session.setAttribute("cg",cg);
                    return "redirect:/login";
                }
            }
        }

        return "redirect:/register";
    }

    @Override
    public String register(Model model) {
        List<Pjclass> list = pjclassMapper.selectByExample(null);
        model.addAttribute("list",list);
        return "student/register";
    }

    @Override
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("user");
        session.removeAttribute("errorInfo");
        session.removeAttribute("cxdl");
        session.removeAttribute("roleid");
        return "redirect:/login";
    }

    @Override
    public String tlogout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("user");
        session.removeAttribute("errorInfo");
        session.removeAttribute("roleid");
        return "redirect:/login";
    }

    @Override
    public String alogout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("user");
        session.removeAttribute("errorInfo");
        session.removeAttribute("roleid");
        return "redirect:/login";
    }

    @Override
    public String llogout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("errorInfo");
        session.removeAttribute("cxdl");
        session.removeAttribute("roleid");
        return  "redirect:/login";
    }

    @Override
    public String zclogout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("wk");
        session.removeAttribute("cz");
        return "redirect:/register";
    }

    @Override
    public String xiugai(String userid, String userpwd, HttpServletRequest request) {
        Integer aff = usersMapper.updateByUserId(userid,userpwd);
        String cxdl ="";
        if (aff>0){
            cxdl = "cxdl";
            request.getSession().setAttribute("cxdl",cxdl);
            return "redirect:/login";
        }
        return "redirect:/logout";
    }

    @Override
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("roleid")!=null){
            if (session.getAttribute("roleid").equals(1)){
                return "teacher/manage";
            }else if (session.getAttribute("roleid").equals(2)){
                return "student/StuMan";
            }else if (session.getAttribute("roleid").equals(3)){
                return "admin/AdminManage";
            }
        }
        return "student/login";
    }
}
