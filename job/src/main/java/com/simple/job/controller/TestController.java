package com.simple.job.controller;

import com.simple.job.job.QuartzJob;
import com.simple.job.service.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shitian
 * @create 2018-07-23 上午12:00
 */
@RestController
public class TestController {

    @Autowired
    private QuartzManager quartzManager;

    @RequestMapping("/add")
    public Object add() {
        try {
            String jobName="job1";
            String jobGroupName="job1";
            String jobTime="0/5 * * * * ? ";
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            System.out.println("TestQuartJob 开始启动 》》》》》："+dateFormat.format(new Date()));
            quartzManager.addJob(QuartzJob.class, jobName, jobGroupName, jobTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

}
