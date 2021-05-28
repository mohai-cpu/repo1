package cn.itcast.study.mythread.demotest;

public class Thread11 extends Thread {
    @Override
    public void run() {
        System.out.println("thread11 run priority="+this.getPriority());
    }
}
