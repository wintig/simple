package com.simple.job.job;

import com.simple.job.service.SendService;
import com.simple.job.utils.DateUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;



/**
 * @author shitian
 * @create 2018-07-22 下午11:57
 */
@Component
public class QuartzJob implements Job, Serializable {

    @Autowired
    public SendService sendService;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        System.out.println("TestQuartJob 的运行 ："+dateFormat.format(new Date()));
        sendService.send();
    }


    public static Trigger buildTrigger() {

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("Send_Audit", "Send_Group")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(0))
                .startAt(DateUtils.localTime2date(LocalTime.now().plusSeconds(2)))  //延迟2秒发送
                .build();

        return trigger;


    }


}