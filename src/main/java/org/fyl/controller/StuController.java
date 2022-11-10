package org.fyl.controller;

import org.fyl.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class StuController {
    @Autowired
    StuService stuService;
    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
    @RequestMapping(value = "/match")
    @ResponseBody
    public List<String> match(String gradeAndClass,String content){
        if(content==""){
            return null;
        }

        return stuService.matchByGradeAndContent(gradeAndClass,content);
    }
}
