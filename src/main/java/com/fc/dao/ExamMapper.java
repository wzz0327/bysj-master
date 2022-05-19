package com.fc.dao;

import com.fc.entity.Exam;
import com.fc.entity.ExamExample;
import java.util.List;

import com.fc.entity.Paper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ExamMapper {
    long countByExample(ExamExample example);

    int deleteByExample(ExamExample example);

    int deleteByPrimaryKey(Integer eid);

    int insert(Exam record);

    int insertSelective(Exam record);

    List<Exam> selectByExample(ExamExample example);

    Exam selectByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") Exam record, @Param("example") ExamExample example);

    int updateByExample(@Param("record") Exam record, @Param("example") ExamExample example);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);



    Exam findByEid(Integer eid);

    List<Exam> finbyclassid(@Param("classid") Integer classid);

    Exam findByPname(String pname);

    //List<Exam> selectByclassid(@Param("classid") int classid);

    void deleteByEid(Integer eid);

    void deleteByCno(Integer cno);
}