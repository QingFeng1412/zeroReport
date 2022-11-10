package org.fyl.service;

import org.apache.ibatis.annotations.Param;
import org.fyl.pojo.Stu;

import java.util.List;

public interface StuService {
    Stu selectByGradeAndClassAndName(String gradeAndClass, String name);
    //以班级和姓名(一点内容)匹配
    List<String> matchByGradeAndContent(String gradeAndClass, String content);
}
