package cn.itcast.study.mythread.twochapter;

public class TwoThread30 extends Thread {
    @Override
    public void run() {
        MyService7.printA();
    }
}
