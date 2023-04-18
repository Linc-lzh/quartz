package com.tuling.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TestJob {

    public static void main(String[] args) {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1","group1")
                .usingJobData("job","jobDetail")
                .usingJobData("name","jobDetail")
                .usingJobData("count1",0)
                .build();

        int count=0;
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","trigger1")
                .usingJobData("trigger","trigger")
                .usingJobData("count",count)
                //.usingJobData("name","trigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
