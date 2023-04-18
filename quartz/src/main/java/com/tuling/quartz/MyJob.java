package com.tuling.quartz;

import org.quartz.*;

import java.util.Date;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class MyJob implements Job {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        /*JobDataMap jobDetailMap = context.getJobDetail().getJobDataMap();
        JobDataMap triggerMap = context.getTrigger().getJobDataMap();
        JobDataMap mergeMap = context.getMergedJobDataMap();
        System.out.println("jobDetailMap:"+jobDetailMap.getString("job"));
        System.out.println("triggerMap:"+triggerMap.getString("trigger"));
        System.out.println("mergeMap:"+mergeMap.getString("trigger"));

        System.out.println("name:"+name);*/

        /*System.out.println("jobDetail:"+System.identityHashCode(context.getJobDetail()));
        System.out.println("job:"+System.identityHashCode(context.getJobInstance()));*/

        /*System.out.println("execute:"+new Date());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        JobDataMap triggerMap = context.getTrigger().getJobDataMap();
        JobDataMap jobDetailMap = context.getJobDetail().getJobDataMap();
        triggerMap.put("count",triggerMap.getInt("count")+1);
        jobDetailMap.put("count1",jobDetailMap.getInt("count1")+1);
        System.out.println("triggerMap count:"+triggerMap.getInt("count"));
        System.out.println("jobDetailMap count:"+jobDetailMap.getInt("count1"));
    }
}
