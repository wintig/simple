package demo01;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shitian
 * @create 2018-07-21 下午11:13
 */
public class HelloJob implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //打印当前的执行时间
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("【任务启动】：当前时间是：" + sdf.format(currentDate));
    }
}
