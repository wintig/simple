package com.simple.job.job;

import com.simple.job.service.SendService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shitian
 * @create 2018-07-22 下午11:57
 */
@Component
public class QuartzJob implements Job, Serializable{

    @Autowired
    public SendService sendService;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        System.out.println("TestQuartJob 的运行 ："+dateFormat.format(new Date()));
        sendService.send();
    }

}