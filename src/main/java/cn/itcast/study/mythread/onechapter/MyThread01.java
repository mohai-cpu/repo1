package cn.itcast.study.mythread.onechapter;

public class MyThread01 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i=0;i<500;i++){
            System.out.println("i="+(i+1));
        }
        System.out.println("MyThread");
    }
}
