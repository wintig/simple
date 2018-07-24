package com.simple.job.service;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author shitian
 * @create 2018-07-22 下午11:58
 */
@Service
public class SendService {

    public void send() {
        System.out.println("【任务启动】 ： " + new Date());
    }

}
