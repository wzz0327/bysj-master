package com.fc.service.impl;

import com.fc.dao.*;
import com.fc.entity.*;
import com.fc.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private StudentexamMapper studentexamMapper;
    @Autowired
    private StudentsubjectMapper studentsubjectMapper;
    @Autowired
    private  SubjectMapper subjectMapper;

//    @Override
//    public String examlist(Model model, HttpServletRequest request) {
//        List<Exam> exams = examMapper.selectByExample(null);
//        if (exams.size()>0){
//            model.addAttribute("examslenth", exams.size());
//            model.addAttribute("exams", exams);
//        }
//        return "student/examList";
//
//    }
    @Override
    public String examlist(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Integer classid = (Integer) session.getAttribute("classid");
        List<Exam> exams = examMapper.finbyclassid(classid);
        for (Exam exam:exams){
            Course byCno=courseMapper.findByCno(exam.getCno());
            exam.setCname(byCno.getCname());
        }
        model.addAttribute("examslenth",exams.size());
        model.addAttribute("exams",exams);
        return "student/examList";

    }
    @Override
    public Exam findExamByEid(Exam exams) {
        Exam exam = examMapper.selectByPrimaryKey(exams.getEid());
        if (exam!=null){
            return exam;
        }else {
            return null;
        }
    }

    @Override
    public String paper(Integer eid, Model model, HttpServletRequest request) {
        List<Paper> Single=paperMapper.finbystype(eid,2);
        Integer cont=Single.size();
        request.getSession().setAttribute("single",Single);
        model.addAttribute("single",Single);
        model.addAttribute("cont",cont);

//        List<Paper> Multiple=paperMapper.finbystype(eid,2);
//        Integer cont1=Multiple.size();
//        request.getSession().setAttribute("multiple",Multiple);
//        model.addAttribute("multiple",Multiple);
//        model.addAttribute("cont1",cont1);


        Exam exam=examMapper.findByEid(eid);
        model.addAttribute("exam",exam);
        return "student/papers";
    }

    @Override
    public String PaperScore(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Integer classid =(Integer)session.getAttribute("classid") ;
        Integer userid =(Integer)session.getAttribute("userid");
        List<Paper> slist= (List<Paper>)session.getAttribute("single");

        Integer eid =Integer.parseInt(request.getParameter("eid"));

        Exam byEid = examMapper.findByEid(eid);
        //
        Integer singlescore = byEid.getSinglecore();

        String stuAnsArr[] = null;
        //分数
        Integer score =0;
        for (int i = 0; i < slist.size(); ++i) {
            Paper paper = slist.get(i);
            stuAnsArr =request.getParameterValues(String.valueOf(paper.getSid()));//获取每道题的答案
            //如果是多选题，存在多个选项值，因此需要getParameterValues方法获取多个值
            if (stuAnsArr != null) {
                String studentkeys = ""; //每道题的答案
                for (int j = 0; j < stuAnsArr.length; j++) {//多选题拥有多个答案
                    studentkeys += stuAnsArr[j];//组装学生答案
                }
                if (studentkeys.equalsIgnoreCase(paper.getSkey())) {
                    score =score+singlescore;
                }else {
                }
            }else {
                System.out.println("提交失败！");
            }
        }
        Integer zscore =slist.size()*singlescore;
        String pname = request.getParameter("pname");
        String tjtime = request.getParameter("tjtime");
        model.addAttribute("score",score);
        Studentexam studentexam = new Studentexam();
        studentexam.setEid(eid);
        studentexam.setPname(pname);
        studentexam.setUserid(userid);
        studentexam.setClassid(classid);
        studentexam.setZscore(zscore);
        studentexam.setScore(score);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try {
            ts = Timestamp.valueOf(tjtime);
            System.out.println(ts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        studentexam.setTjtime(ts);
        studentexamMapper.insertSelective(studentexam);

        Integer seid= studentexam.getSeid();
        System.out.println(seid);
        for (int i = 0; i < slist.size(); ++i) {
            Paper paper = slist.get(i);
            stuAnsArr =request.getParameterValues(String.valueOf(paper.getSid()));//获取每道题的答案
            //如果是多选题，存在多个选项值，因此需要getParameterValues方法获取多个值
            if (stuAnsArr != null) {
                String studentkeys = ""; //每道题的答案
                for (int j = 0; j < stuAnsArr.length; j++) {//多选题拥有多个答案
                    studentkeys += stuAnsArr[j];//组装学生答案
                    //System.out.println(studentkeys);
                    Studentsubject studentsubject = new Studentsubject();
                    studentsubject.setSeid(seid);
                    studentsubject.setUserid(userid);
                    studentsubject.setEid(eid);
                    studentsubject.setSid(paper.getSid());
                    studentsubject.setStudentkey(studentkeys);
                    studentsubjectMapper.insertSelective(studentsubject);
                }
            }
        }
        return "student/paperScore";
    }

    @Override
    public Studentexam findOneStuExam(Exam exam, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Integer userid= (Integer) session.getAttribute("userid");
        Studentexam studentexam = studentexamMapper.findByOne(userid,exam.getEid());

        return studentexam;
    }

    @Override
    public String findAllStuPaper(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Integer userid= (Integer) session.getAttribute("userid");
//        StudentexamExample example = new UsersExample();
//        UsersExample.Criteria criteria = example.createCriteria();
//        criteria.andUseridEqualTo(userid);
        StudentexamExample studentexamExample = new StudentexamExample();
        StudentexamExample.Criteria criteria = studentexamExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<Studentexam> studentexams = studentexamMapper.selectByExample(studentexamExample);

//        List<Studentexam> stuexamlist = studentexamMapper.findByUserid(userid);
        model.addAttribute("stuexamlist",studentexams);
        return "student/stuPaperList";
    }

    @Override
    public String stuPaper(Model model, HttpServletRequest request,Integer seid) {
        HttpSession session = request.getSession(true);
        Integer userid= (Integer) session.getAttribute("userid");
        List<Studentsubject> stukeys = studentsubjectMapper.findBySeid(userid,seid);
        for (Studentsubject studentsubject :stukeys){
            Subject bySid = subjectMapper.findBySid(studentsubject.getSid());
            Exam byEid = examMapper.findByEid(studentsubject.getEid());
            model.addAttribute("exam",byEid);
            studentsubject.setSubject(bySid);
        }
        model.addAttribute("stukeys",stukeys);
        return "student/stuPaper";
    }

    @Override
    public Studentexam findBySeid(Studentexam exams) {
        Studentexam stexam = studentexamMapper.findByseid(exams.getSeid());
        if (stexam!= null) {
            return stexam;
        } else {
            return null;
        }
    }

    @Override
    public Exam findByPname(Exam exams) {
        Exam exam = examMapper.findByPname(exams.getPname());
        if (exam!= null) {
            return exam;
        } else {
            return null;
        }
    }



//    @Override
//    public ResultVO examlist(Integer pageNum, Integer pageSize, Integer eid) {
//        ResultVO resultVO;
//        List<Exam> exams;
//
//        DataVO<Exam> dataVO;
//
//        if(eid!=null){
//            exams =new ArrayList<>();
//            Exam exam = examMapper.selectByPrimaryKey(eid);
//
//            if (exam ==null){
//
//                dataVO=new DataVO<>(0, exams,pageNum,pageSize);
//                resultVO=new ResultVO(4000,"没有这个收藏表",false,dataVO);
//
//            }else {
//
//                exams.add(exam);
//                dataVO=new DataVO<>(1, exams,pageNum,pageSize);
//                resultVO=new ResultVO(200,"查到了收藏表",true,dataVO);
//            }
//
//
//        }else {
//            PageHelper.startPage(pageNum,pageSize);
//            exams = examMapper.selectByExample(null);
//            if (exams.size()==0){
//                dataVO=new DataVO<>(0, exams,pageNum,pageSize);
//                resultVO=new ResultVO(4100,"没有收藏表",false,dataVO);
//
//            }else {
//                PageInfo<Exam> pageInfo = new PageInfo<>(exams);
//                dataVO=new DataVO<>(pageInfo.getTotal(), exams,pageNum,pageSize);
//                resultVO=new ResultVO(200,"收藏表查询成功！！！",true,dataVO);
//
//            }
//        }
//        return resultVO;
//    }

}
