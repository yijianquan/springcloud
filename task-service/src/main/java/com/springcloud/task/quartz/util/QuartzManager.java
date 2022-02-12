package com.springcloud.task.quartz.util;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.util.Map;

public class QuartzManager {

    private static final SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    public static void addJob(String jobName, Class jobClass, String cron, Map<String, Object> params) {
        addJob(jobName, QuartzGroupName.JobGroupName.DEFAULT_JOB_GROUP.name(),
                QuartzGroupName.TriggerGroupName.DEFAULT_TRIGGER_NAME.name(),
                jobClass, cron, params);
    }

    public static void addJob(String jobName, String jobGroupName, String triggerGroupName, Class jobClass,
                              String cron, Map<String, Object> params) {
        try {
            Scheduler sched = schedulerFactory.getScheduler();
            if (sched.isShutdown()) {
                return;
            }
            JobDataMap dataMap = new JobDataMap(params);
            JobDetail jobDetail = JobBuilder
                    .newJob(jobClass)
                    .withIdentity(jobName, jobGroupName)
                    .setJobData(dataMap).build();// 任务名，任务组，任务执行类
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(jobName, triggerGroupName)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .usingJobData(jobDetail.getJobDataMap())
                    .build();
            sched.scheduleJob(jobDetail, trigger);
            sched.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void modifyJobTime(String jobName, String triggerGroupName, String cron) {
        try {
            Scheduler sched = schedulerFactory.getScheduler();
            TriggerKey triggerKey = new TriggerKey(jobName, triggerGroupName);
            CronTriggerImpl trigger = (CronTriggerImpl) sched.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cron)) {
                trigger.setCronExpression(cron);
                sched.rescheduleJob(triggerKey, trigger);
                sched.resumeJob(trigger.getJobKey());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeJob(String jobName, String triggerName) {
        removeJob(jobName, QuartzGroupName.JobGroupName.DEFAULT_JOB_GROUP.name(),
                triggerName, QuartzGroupName.TriggerGroupName.DEFAULT_TRIGGER_NAME.name());
    }

    public static void removeJob(String jobName, String jobGroupName,
                                 String triggerName, String triggerGroupName) {
        try {
            Scheduler sched = schedulerFactory.getScheduler();
            TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroupName);
            sched.pauseTrigger(triggerKey);
            sched.unscheduleJob(triggerKey);
            sched.deleteJob(new JobKey(jobName, jobGroupName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void startJobs() {
        try {
            Scheduler sched = schedulerFactory.getScheduler();
            if (!sched.isStarted()) {
                sched.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void shutdownJobs() {
        try {
            Scheduler sched = schedulerFactory.getScheduler();
            if (!sched.isShutdown()) {
                sched.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
