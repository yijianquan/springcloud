package com.springcloud.task.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class UserQuartz implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("定时执行Job");
    }

}
