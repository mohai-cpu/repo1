package cn.itcast.study.mythread.twochapter;

import java.security.Provider;

public class TwoThread31 extends Thread {
    private MyService8 service8;

    public TwoThread31(MyService8 service8) {
        this.service8 = service8;
    }

    @Override
    public void run() {
        service8.printA();
    }
}
