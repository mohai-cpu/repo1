package cn.itcast.study.mythread.demotest;

public class Thread02 extends Thread {
    @Override
    public void run() {
        System.out.println("thread02 run priority="+this.getPriority());
    }
}
