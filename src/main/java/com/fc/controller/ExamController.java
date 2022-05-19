package com.fc.controller;

import com.fc.entity.Exam;
import com.fc.entity.Studentexam;
import com.fc.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@Controller
@RequestMapping("/")
public class ExamController {
    @Autowired
    private ExamService examService;
    @GetMapping("examList")
    public String examlist(Model model, HttpServletRequest request) {
        return examService.examlist(model,request);
    }

    @ResponseBody
    @PostMapping("findExamByEid")
    public Exam findExamByEid(@RequestBody Exam exams) {
        return examService.findExamByEid(exams);
    }

    @GetMapping("paper")
    public String paper(Integer eid,Model model,HttpServletRequest request) {
        return examService.paper(eid,model,request);
    }
    //试卷成绩
    @PostMapping("PaperScore")
    public String PaperScore(Model model, HttpServletRequest request) {
        return examService.PaperScore(model,request);
    }
    //查询是否做过该试卷
    @PostMapping("findOneStuExam")

    public Studentexam findOneStuExam(@RequestBody Exam exam, HttpServletRequest request) {
        return examService.findOneStuExam(exam,request);
    }

    @GetMapping("findAllStuPaper")
    public String findAllStuPaper(Model model,HttpServletRequest request){
        return examService.findAllStuPaper(model,request);
    }
    @PostMapping("stuPaper")
    public String stuPaper(Model model,HttpServletRequest request,Integer seid){
        return examService.stuPaper(model,request,seid);
    }

    @RequestMapping("findBySeid")
        public Studentexam findBySeid(@RequestBody Studentexam exams){
        return examService.findBySeid(exams);
    }
    @RequestMapping("findByPname")
    public Exam findByPname(@RequestBody Exam exams){
        return examService.findByPname(exams);
    }


}
