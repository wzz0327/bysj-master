package com.fc.service;

import com.fc.entity.Course;
import com.fc.entity.Exam;
import com.fc.entity.Pjclass;
import com.fc.entity.Users;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface TeacherService {
    String studentList(HttpSession session, Model model, HttpServletResponse response, Integer pageNum);

    String addStu(Users users);

    String deleteStu(Integer userid);

    List<Pjclass> findAllClass();

    Users StuEdit(Users users);

    String updateStu(Users user);

    String deleteManyStu(String ids);

    String deleteAll(HttpSession session);

    String selectexam(Model model, Integer pageNum);

    String deleteManyExam(String ids);

    String deleteExam(Integer eid);

    Exam findByOneExam(Exam exams);

    String updateExam(Exam exam);

    String paperDetails(Integer eid, Model model);

    List<Course> courselist();

    String insertexam(Exam exam,Model model);

    //String finddanxuan(Model model, Integer pageNum);
}
