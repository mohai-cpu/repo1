package cn.itcast.study.mythread.demotest;

public class Thread10 extends Thread {
    @Override
    public void run() {
        System.out.println("thread10 run priority="+this.getPriority());
        Thread11 thread11 = new Thread11();
        thread11.start();
    }
}
