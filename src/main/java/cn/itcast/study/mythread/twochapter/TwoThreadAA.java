package cn.itcast.study.mythread.twochapter;

public class TwoThreadAA extends Thread {
    private Sub sub;

    public TwoThreadAA(Sub sub) {
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
