package com.tuling.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) {
        Timer t = new Timer();//任务启动
        for (int i=0; i<2; i++){
            TimerTask task = new FooTimerTask("foo"+i);
            t.scheduleAtFixedRate(task,new Date(),2000);//任务添加   10s 5次   4 3
            // 预设的执行时间nextExecutTime 12:00:00   12:00:02  12:00:04
            //schedule  真正的执行时间 取决上一个任务的结束时间  ExecutTime   03  05  08  丢任务（少执行了次数）
            //scheduleAtFixedRate  严格按照预设时间 12:00:00   12:00:02  12:00:04（执行时间会乱）
            //单线程  任务阻塞  任务超时
        }
    }
}
class FooTimerTask extends TimerTask {

    private String name;

    public FooTimerTask(String name) {
        this.name = name;
    }

    public void run() {
        try {
            System.out.println("name="+name+",startTime="+new Date());
            Thread.sleep(3000);
            System.out.println("name="+name+",endTime="+new Date());

            //线程池执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
