package com.fc.service.impl;

import com.fc.dao.*;
import com.fc.entity.*;
import com.fc.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private PjclassMapper classDao;

    @Autowired
    private PjclassMapper pjclassMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private ExamMapper examDao;

    @Autowired
    private PaperMapper paperDao;

    @Autowired
    private StudentexamMapper studentexamDao;

    @Autowired
    private StudentsubjectMapper studentsubjectDao;

    @Autowired
    private CourseMapper courseDao;

    @Autowired
    private SubjectMapper subjectDao;
    @Override
    public String studentList(HttpSession session, Model model,
                              HttpServletResponse response,
                              Integer pageNum) {
        Integer classid= (Integer) session.getAttribute("Tclassid");
        Pjclass pjclass = classDao.selectByPrimaryKey(classid);
        List<Pjclass> pjclassList = classDao.selectByExample(null);
        model.addAttribute("pj",pjclass);
        model.addAttribute("pjclassList",pjclassList);
        PageHelper.startPage(pageNum, 6);

        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andRoleidEqualTo(2);
        List<Users> users = usersMapper.selectByExample(example);

        PageInfo<Users> info = new PageInfo<>(users);
        model.addAttribute("pageInfo", info);

        response.addHeader("x-frame-options","SAMEORIGIN");
        return "teacher/StudentList";
    }

    @Override
    public String addStu(Users user) {

        List<Users> users;
        if (user.getUsername().equals("")) {
            System.out.println("用户名不能为空");
            return "redirect:/StudentList";
        } else {
            UsersExample example = new UsersExample();
            UsersExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(user.getUsername());
            users = usersMapper.selectByExample(example);
        }

        if (users.size() > 0) {
            System.out.println("用户名已存在");
            return "redirect:/StudentList";
        } else {
            if (user.getUserpwd().equals("") || user.getTruename().equals("")) {
                System.out.println("密码或真实姓名不能为空");
                return "redirect:/StudentList";
            } else {
                user.setRoleid(2);
                int insert = usersMapper.insert(user);
                if (insert > 0) {
                    System.out.println("添加成功");
                    return "redirect:/StudentList";
                }
            }
            return "redirect:/StudentList";
        }
    }

    @Override
    public String deleteStu(Integer userid) {
        int i = usersMapper.deleteByPrimaryKey(userid);
            if (i>0){
                System.out.println("删除成功");
            }
        return "redirect:/StudentList";
    }

    @Override
    public List<Pjclass> findAllClass() {
        List<Pjclass> pjclasses = pjclassMapper.selectByExample(null);
        if (pjclasses.size()>0) {
            return pjclasses;
        }
        return null;
    }

    @Override
    public Users StuEdit(Users users) {
        Users user=usersMapper.selectByPrimaryKey(users.getUserid());
        if (user!=null) {
           return user;
        }
        return null;
    }

    @Override
    public String updateStu(Users user) {
        usersMapper.updateByPrimaryKey(user);
        return "redirect:/StudentList";
    }

    @Override
    public String deleteManyStu(String ids) {
        // 接收包含stuId的字符串，并将它分割成字符串数组
        String[] stuList = ids.split(",");
        // 将字符串数组转为List<Intger> 类型
        List<Integer> LString = new ArrayList<>();

        for(String str : stuList){
            LString.add(new Integer(str));
        }
        for (int i=0;i<LString.size();i++) {
            examDao.deleteByPrimaryKey(LString.get(i));
        }
        return "redirect:/selectexam";
    }

    @Override
    public String deleteAll(HttpSession session) {
        Integer classid= (Integer) session.getAttribute("classid");
        usersMapper.deleteByClassid(classid);
        return "redirect:/StudentList";
    }

    @Override
    public String selectexam(Model model, Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Exam> exams = examDao.selectByExample(null);
        PageInfo<Exam> info = new PageInfo<>(exams);
        model.addAttribute("examlist",info);
        return "teacher/SelectExam";
    }

    @Override
    public String deleteManyExam(String ids) {
        // 接收包含stuId的字符串，并将它分割成字符串数组
        String[] stuList = ids.split(",");
        // 将字符串数组转为List<Intger> 类型
        List<Integer> LString = new ArrayList<>();

        for(String str : stuList){
            LString.add(new Integer(str));
            Integer eid = new Integer(str);
            examDao.deleteByEid(eid);
            studentsubjectDao.deleteByEid(eid);
            studentexamDao.deleteByEid(eid);
        }
        return "redirect:/selectexam";
    }

    @Override
    public String deleteExam(Integer eid) {
        paperDao.deleteByEid(eid);
        examDao.deleteByPrimaryKey(eid);
        studentsubjectDao.deleteByEid(eid);
        studentexamDao.deleteByEid(eid);
        return "redirect:/selectexam";
    }

    @Override
    public Exam findByOneExam(Exam exams) {
        Exam exam = examDao.selectByPrimaryKey(exams.getEid());
        if (exam != null) {
            return exam ;
        } else {
            return null;
        }
    }

    @Override
    public String updateExam(Exam exam) {
        Integer eid = exam.getEid();
        String pname = exam.getPname();
        studentexamDao.updatePname(pname,eid);
        examDao.updateByPrimaryKey(exam);
        return "redirect:/selectexam";
    }

    @Override
    public String paperDetails(Integer eid, Model model) {
        List<Paper> tm = paperDao.selectByEid(eid);
        Exam exam = examDao.selectByPrimaryKey(eid);
        model.addAttribute("exam",exam);
        model.addAttribute("tm",tm);
        return "teacher/paperDetails";
    }

    @Override
    public List<Course> courselist() {
        List<Course> courses = courseDao.selectByExample(null);
        return courses;
    }

    @Override
    public String insertexam(Exam exam,Model model) {
        examDao.insert(exam);
        Integer eid = exam.getEid();
        //单选随机组题
        List<Subject> singlelsit = subjectDao.finbytype(1, exam.getCno());
        List<Subject> resultList1 = new ArrayList<>();
        Random random = new Random();
        if(exam.getSinglenumber()>0){
            for(int i=1;i<=exam.getSinglenumber();i++){
                int n=random.nextInt(singlelsit.size());
                Subject q=singlelsit.get(n);
                if(resultList1.contains(q)){
                    i--;
                }else{
                    resultList1.add(singlelsit.get(n));
                    Paper paper = new Paper();
                    paper.setEid(eid);
                    paper.setSid(q.getSid());
                    paper.setCno(exam.getCno());
                    paper.setStype(q.getStype());
                    paper.setScontent(q.getScontent());
                    paper.setSa(q.getSa());
                    paper.setSb(q.getSb());
                    paper.setSc(q.getSc());
                    paper.setSd(q.getSd());
                    paper.setSkey(q.getSkey());
                    paperDao.insert(paper);
                }
            }
        }
        //多选随机组题
        List<Subject> multiplelsit = subjectDao.finbytype(2, exam.getCno());
        List<Subject> resultList2 = new ArrayList<Subject>();
        if(exam.getMultiplenumber()>0){
            for(int i=1;i<=exam.getMultiplenumber();i++){
                int n1=random.nextInt(multiplelsit.size());
                Subject q1=multiplelsit .get(n1);
                if(resultList2 .contains(q1)){
                    i--;
                }else{
                    resultList2.add(multiplelsit.get(n1));
                    Paper p = new Paper();
                    p.setEid(eid);
                    p.setSid(q1.getSid());
                    p.setCno(exam.getCno());
                    p.setStype(q1.getStype());
                    p.setScontent(q1.getScontent());
                    p.setSa(q1.getSa());
                    p.setSb(q1.getSb());
                    p.setSc(q1.getSc());
                    p.setSd(q1.getSd());
                    p.setSkey(q1.getSkey());
                    paperDao.insert(p);
                }
            }
        }
        return "redirect:/selectexam";
    }

    @Override
    public String finddanxuan(Model model, Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Subject> subjects = subjectDao.selectByStype(1);
        PageInfo<Subject> info = new PageInfo<>(subjects);
        model.addAttribute("pageInfo",info);
        return "teacher/Single";
    }

    @Override
    public String addSingle(Subject subject, Model model) {
        int i = subjectDao.insert(subject);
        return "redirect:/finddanxuan";
    }

    @Override
    public String findMultiple(Model model, Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Subject> subjects = subjectDao.selectByStype(2);
        PageInfo<Subject> info = new PageInfo<>(subjects);
        model.addAttribute("pageInfo",info);
        return "teacher/multiple";
    }

    @Override
    public String findAllScore(HttpSession session, Model model) {
        Integer classid=(Integer)session.getAttribute("Tclassid");
        Pjclass pjclass = pjclassMapper.selectByPrimaryKey(classid);
        model.addAttribute("cs",pjclass);
        List<Studentexam> studentexams = studentexamDao.selectByExample(null);

        model.addAttribute("score",studentexams);
//        PageInfo<Studentexam> info = new PageInfo<>(studentexams);
//        model.addAttribute("pageInfo",info);
        return "teacher/studentScore";
    }

}
