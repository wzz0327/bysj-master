package com.fc.dao;

import com.fc.entity.Paper;
import com.fc.entity.PaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperMapper {
    long countByExample(PaperExample example);

    int deleteByExample(PaperExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Paper record);

    int insertSelective(Paper record);

    List<Paper> selectByExample(PaperExample example);

    Paper selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByExample(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    List<Paper> finbystype(@Param("eid") Integer eid, @Param("stype") Integer stype);

    void deleteByEid(@Param("eid") Integer eid);

    List<Paper> selectByEid(@Param("eid") Integer eid);
}