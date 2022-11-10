package org.fyl.mapper;

import org.apache.ibatis.annotations.Param;
import org.fyl.pojo.Data;

import java.util.List;

public interface DataMapper {
    //根据年级，以日查询
    List<Data> selectByGrade(
            @Param("date")
            String date,
            @Param("grade")
            String grade);
    //插入或更新
    int update(Data data);
    int insert(Data data);
    //查询来让service选择插入或更新
    Data selectByKey(
            @Param("date")
            String date,
            @Param("gradeAndClass")
            String  gradeAndClass);
    //根据年级以月查询
    List<Data> selectByMonth(
            @Param("date")
                    String date,
            @Param("grade")
                    String grade
    );


}
