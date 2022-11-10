import org.fyl.pojo.Data;
import org.fyl.service.DataService;
import org.fyl.service.StuService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Test {
    @org.junit.Test
    public void test(){

        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd-HH");
        String date=sf.format(new Date().getTime()-(long)4*60*60*1000);
        System.out.println(date);
    }
}
