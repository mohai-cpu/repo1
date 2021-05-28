package cn.itcast.study.mythread.demotest;


public class Thread06 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5000; i++) {
            System.out.println("i="+(i+1));
        }
    }
}
