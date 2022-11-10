package org.fyl.service.impl;

import org.fyl.mapper.StuMapper;
import org.fyl.pojo.Stu;
import org.fyl.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    StuMapper stuMapper;

    @Override
    public Stu selectByGradeAndClassAndName(String gradeAndClass, String name) {
        return stuMapper.selectByGradeAndClassAndName(gradeAndClass,name);
    }

    @Override
    public List<String> matchByGradeAndContent(String gradeAndClass, String content) {
        return stuMapper.matchByGradeAndContent(gradeAndClass,content);
    }
}
