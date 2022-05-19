package com.fc.service;

import com.fc.entity.Exam;
import com.fc.entity.Studentexam;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@Repository
public interface ExamService {

    String examlist(Model model, HttpServletRequest request);

    Exam findExamByEid(Exam exams);

    String paper(Integer eid, Model model, HttpServletRequest request);

    String PaperScore(Model model, HttpServletRequest request);

    Studentexam findOneStuExam(Exam exam, HttpServletRequest request);

    String findAllStuPaper(Model model, HttpServletRequest request);

    String stuPaper(Model model, HttpServletRequest request,Integer seid);

    Studentexam findBySeid(Studentexam exams);

    Exam findByPname(Exam exams);
}
