package demo01;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author shitian
 * @create 2018-07-21 下午11:16
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {

        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();

        //创建一个Trigger实例
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

        //创建Scheduler实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }

}
