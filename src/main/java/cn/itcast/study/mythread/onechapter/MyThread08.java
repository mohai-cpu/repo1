package cn.itcast.study.mythread.onechapter;

public class MyThread08 extends Thread{
    @Override
    public void run() {
        System.out.println("run="+this.isAlive());
    }
}
