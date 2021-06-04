package cn.itcast.study.mythread.twochapter;

public class TwoThreadBB extends Thread {
    private Sub sub;

    public TwoThreadBB(Sub sub) {
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
