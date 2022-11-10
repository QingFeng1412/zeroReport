package org.fyl.service.impl;

import org.fyl.mapper.DataMapper;
import org.fyl.pojo.Data;
import org.fyl.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class DataServiceImpl implements DataService {
    @Autowired
    DataMapper dataMapper;

    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
    //按年级以日查询
    @Override
    public List<Data> selectByGrade(String date, String grade) {
        return dataMapper.selectByGrade(date,grade);
    }
    //updateOrInsert方法选择所用函数
    @Override
    public Data selectByKey(String date, String gradeAndClass) {
        return dataMapper.selectByKey(date,gradeAndClass);
    }
    //按年级以月查询
    @Override
    public List<Data> selectByMonth(String date, String grade) {
        return dataMapper.selectByMonth(date,grade);
    }
    //插入或者更改数据（防止多次提交）
    @Override
    public int updateOrInsert(Data data) {
        Data temp=selectByKey(data.getDate(),data.getGradeAndClass());
        if(temp==null){
            return dataMapper.insert(data);
        }
        return dataMapper.update(data);
    }


}
