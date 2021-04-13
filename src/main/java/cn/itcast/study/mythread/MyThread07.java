package cn.itcast.study.mythread;

public class MyThread07 extends Thread {
    public MyThread07(){
        System.out.println("当前线程名称="+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("当前线程名称dsada="+Thread.currentThread().getName());
    }
}
