package cn.itcast.study.mythread.twochapter;

public class TwoThread08 extends Thread {
    @Override
    public void run() {
        MyService myService = new MyService();
        myService.service1();
    }
}
