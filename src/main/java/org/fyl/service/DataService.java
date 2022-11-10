package org.fyl.service;

import org.apache.ibatis.annotations.Param;
import org.fyl.pojo.Data;

import java.util.List;

public interface DataService {
    List<Data> selectByGrade (String date, String grade);
    int updateOrInsert (Data data);
    Data selectByKey(String date,String  gradeAndClass);
    List<Data> selectByMonth(String date, String grade);
}
