package org.fyl.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.fyl.pojo.Data;
import org.fyl.pojo.User;
import org.fyl.service.DataService;
import org.fyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    DataService dataService;
    /*
        判断登录并跳转
     */
    @RequestMapping("/login")
    public String login(String userId, String userPassword, HttpServletRequest request, HttpServletResponse response,HttpSession session
    ) throws ServletException, IOException {
        User user=userService.selectUser(userId,userPassword);
        if(user==null){
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("/").forward(request,response);
        }

            session.setAttribute("user",user);

            return "success";
    }
    /*
    按照年级和单日日期查询
     */
    @RequestMapping("/select")
    @ResponseBody
    public List<Data> select(
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date date,String grade,HttpServletRequest httpServletRequest){

        User user= (User) httpServletRequest.getSession().getAttribute("user");
        List<Data> list=dataService.selectByGrade(new SimpleDateFormat("yyyy-MM-dd").format(date),user.getGrade());
        httpServletRequest.setAttribute("list",list);

        return list;

    }
    /*
        退出
     */
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.invalidate();
        return "forward:/";
    }
    /*
   按照年级和月份查询
    */
    @RequestMapping("/selectByMonth")
    @ResponseBody
    public List<Data> selectByMonth(
            @DateTimeFormat(pattern = "yyyy-MM")
            Date date,String grade,HttpServletRequest httpServletRequest){

        User user= (User) httpServletRequest.getSession().getAttribute("user");
        List<Data> list=dataService.selectByMonth(new SimpleDateFormat("yyyy-MM").format(date),user.getGrade());
        httpServletRequest.setAttribute("list",list);

        return list;

    }
    @RequestMapping("/selectByMonth2xls")
    public void selectByMonth2xls(
                    @DateTimeFormat(pattern = "yyyy-MM")
                    Date date,String grade,HttpServletRequest httpServletRequest,
                    HttpServletResponse response) throws Exception{

        User user= (User) httpServletRequest.getSession().getAttribute("user");
        List<Data> list=dataService.selectByMonth(new SimpleDateFormat("yyyy-MM").format(date),user.getGrade());

        //用apache的poi创建excel文件,并把activityList写入excel文件中
        //创建HSSFWorkbook对象，对应一个excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //使用wb创建HSSFSheet对象，对应wb文件中的一页
        HSSFSheet sheet = wb.createSheet("零汇报情况");//设置页名
        //使用sheet创建HSSFRow对象，对应sheet中的一行
        HSSFRow row = sheet.createRow(0);//索引为0就是第一行
        //使用row创建HSSFCell对象，对应row中的列
        HSSFCell cell = row.createCell(0);//索引为0就是第一列
        //往列里设置值
        cell.setCellValue("日期");
        cell = row.createCell(1);
        cell.setCellValue("班级");
        cell = row.createCell(2);
        cell.setCellValue("信息");
        cell = row.createCell(3);


        //遍历list,创建Row
        //先判断list有没有数据
        if(list!=null&&list.size()>0){
            Data data=null;//activity拿到外面定义就不用每次循环都创建，效率更高

            for(int i=0;i<list.size();i++){
                data = list.get(i);
                //每遍历出一个activity，生成一行
                row=sheet.createRow(i+1);
                cell = row.createCell(0);

                cell.setCellValue(data.getDate()+"");
                cell = row.createCell(1);
                cell.setCellValue(data.getGradeAndClass());
                cell = row.createCell(2);
                cell.setCellValue(data.getInf());


            }
        }

        //设置响应类型 application/octet-stream表示excel文件
        response.setContentType("application/octet-stream;charset=utf-8");
        //设置响应头  Content-Disposition打开方式 attachment以附件的形式
        response.addHeader("Content-Disposition","attachment;filename=zeroReporterList.xls");
        OutputStream out = response.getOutputStream();
        wb.write(out);
        wb.close();
        out.flush();//out由response生成的，tomcat会自己关闭，不能自己关闭，不flush可能会数据丢失

    }


}
