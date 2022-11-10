package org.fyl.controller;

import org.fyl.pojo.Data;
import org.fyl.pojo.Stu;
import org.fyl.service.DataService;
import org.fyl.service.StuService;
import org.fyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
public class DataController {
    @Autowired
    DataService dataService;
    @Autowired
    StuService stuService;
    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
    /*
        提交数据
     */
    @RequestMapping("/submit")
    public String submit(String gradeAndClass,String inf){
        String date=sf.format(new Date().getTime()-(long)4*60*60*1000);
        dataService.updateOrInsert(new Data(gradeAndClass,date,inf));
        return "main";
    }
    @RequestMapping("/submit2")
    public String submit(String gradeAndClass, @RequestParam(required = false) String[] name, @RequestParam(required = false) String[] reason){
        //加RequestParam(required = false)是为了防止有不填人数的情况
        String date=sf.format(new Date().getTime()-(long)4*60*60*1000); //时间减四小时，防止有人过12点填报
        String inf ="";
        Set<Stu> stus=new HashSet<>();//解决提交时姓名相同的问题
        Stu stu;
        if(name==null){//如果是0人，则全部归寝
            if(stuService.matchByGradeAndContent(gradeAndClass,"").size()!=0){
                inf+="全部归寝";
            }
        }else {
            for (int i = 0; i < name.length; i++) {
                stu = stuService.selectByGradeAndClassAndName(gradeAndClass, name[i]);
                if (stu == null) {
                    continue;
                }
                if (stus.add(stu)) {
                    inf += stu.getRoom() + stu.getName();
                    if (reason.length == 0) {
                        inf += " ";//原因未提交
                    } else {
                        inf += reason[i] + " ";
                    }

                }
            }
        }
        if(inf!=""){ //防止班级错误
            dataService.updateOrInsert(new Data(gradeAndClass,date,inf));
        }

        return "main";
    }
}
