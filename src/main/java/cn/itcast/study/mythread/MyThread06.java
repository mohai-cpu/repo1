package cn.itcast.study.mythread;

public class MyThread06 extends Thread {
    private int num = 9;

    @Override
    synchronized public void run() {
        super.run();
        num--;
        System.out.println("由"+this.currentThread().getName()+"计算，num="+num);
    }
}
