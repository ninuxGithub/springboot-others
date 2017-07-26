package com.example.task;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by daile on 2017/7/4.
 */
@Component
@EnableAsync
@EnableScheduling
public class ScheduledTask {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 50000)
    public void reportCurrentTime(){
        System.out.println("当前时间："+DATE_FORMAT.format(new Date()));
    }
}
