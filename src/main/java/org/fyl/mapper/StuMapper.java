package org.fyl.mapper;

import org.apache.ibatis.annotations.Param;
import org.fyl.pojo.Stu;

import java.util.List;

public interface StuMapper {
    //以年级班级和姓名查询
    Stu selectByGradeAndClassAndName(
            @Param("gradeAndClass")
            String gradeAndClass,
            @Param("name")
            String name
            );
    //以班级和姓名(一点内容)匹配
    List<String> matchByGradeAndContent(
            @Param("gradeAndClass")
            String gradeAndClass,
            @Param("content")
            String content
            );
}
