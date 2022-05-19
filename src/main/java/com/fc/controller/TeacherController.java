package com.fc.controller;

import com.fc.dao.PjclassMapper;
import com.fc.dao.UsersMapper;
import com.fc.entity.*;
import com.fc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private PjclassMapper classDao;
    @Autowired
    private UsersMapper usersMapper;

    @RequestMapping("/StudentList")
    private String studentList(HttpSession session, Model model,HttpServletResponse response,
                               @RequestParam(defaultValue = "1") Integer pageNum){
        return teacherService.studentList(session,model,response,pageNum);
    }

    @PostMapping("addStu")
    private String addStu(Users users){
        return teacherService.addStu(users);
    }

    @GetMapping("DeleteStu")
    private String deleteStu(Integer userid){
        return teacherService.deleteStu(userid);
    }

    @ResponseBody
    @GetMapping("findAllClass")
    private List<Pjclass> findAllClass(){
        return teacherService.findAllClass();
    }

    @ResponseBody
    @PostMapping("StuEdit")
    private Users StuEdit(@RequestBody Users user){
        return teacherService.StuEdit(user);
    }

    @PostMapping("updateStu")
    private String updateStu(Users user){
        return teacherService.updateStu(user);
    }

    @RequestMapping("deleteManyStu")
    private String deleteManyStu(String ids){
        return teacherService.deleteManyStu(ids);
    }

    @RequestMapping("deleteAll")
    private String deleteAll(HttpSession session){
        return teacherService.deleteAll(session);
    }

    @RequestMapping("selectexam")
    private String selectexam(Model model,@RequestParam(defaultValue = "1") Integer pageNum){
        return teacherService.selectexam(model,pageNum);
    }

    @RequestMapping("/deleteManyExam")
    private String  deleteManyExam(String ids){
        return teacherService.deleteManyExam(ids);
    }

    @RequestMapping("/deleteExam")
    private String deleteExam(Integer eid){
        return teacherService.deleteExam(eid);
    }

    @ResponseBody
    @RequestMapping("/findByOneExam")
    private Exam findByOneExam(@RequestBody Exam exams){
        return teacherService.findByOneExam(exams);
    }

    @RequestMapping("/updateExam")
    private String updateExam(Exam exam ){
        return teacherService.updateExam(exam);
    }

    @RequestMapping("/paperDetails")
    private String paperDetails (Integer eid,Model model){
        return teacherService.paperDetails(eid,model);
    }

    @ResponseBody
    @RequestMapping("findAllCourse")
    private List<Course> courselist(){
        return teacherService.courselist();
    }

    @RequestMapping("addexam")
    private String addexam(){
        return "/teacher/addexam";
    }

    @RequestMapping("insertexam")
    private String insertexam(Exam exam,Model model){
        return teacherService.insertexam(exam,model);
    }

    @RequestMapping("finddanxuan")
    private String finddanxuan(Model model,@RequestParam(defaultValue = "1") Integer pageNum){
        return teacherService.finddanxuan(model,pageNum);
    }

    @PostMapping("addSingle")
    private String addSingle(Subject subject,Model model){
        return teacherService.addSingle(subject,model);
    }

    @RequestMapping("findMultiple")
    private String findMultiple(Model model,@RequestParam(defaultValue = "1") Integer pageNum){
        return teacherService.findMultiple(model,pageNum);
    }

    @RequestMapping("findAllScore")
    private String findAllScore(HttpSession session,Model model){
        return teacherService.findAllScore(session,model);
    }
}
