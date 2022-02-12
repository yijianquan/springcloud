package com.springcloud.task.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserScheduled {

    @Scheduled(initialDelay = 0, fixedDelay = 10000)
    public void scheduledTemplate() {
        System.out.println("开始执行定时任务");
    }

}
