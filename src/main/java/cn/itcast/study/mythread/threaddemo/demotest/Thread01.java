package cn.itcast.study.mythread.threaddemo.demotest;

public class Thread01 extends Thread {
    @Override
    public void run() {
        System.out.println("thread01 run priority=" + this.getPriority());
        Thread02 thread02 = new Thread02();
        thread02.start();
    }
}
