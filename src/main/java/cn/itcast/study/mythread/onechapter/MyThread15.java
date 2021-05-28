package cn.itcast.study.mythread.onechapter;

public class MyThread15 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            Thread.yield();
            count=count+(i+1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时："+(endTime-beginTime)+"毫秒");
    }
}
