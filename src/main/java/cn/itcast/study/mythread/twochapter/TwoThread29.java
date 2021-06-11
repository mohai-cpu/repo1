package cn.itcast.study.mythread.twochapter;

import java.security.Provider;

public class TwoThread29 extends Thread {
    @Override
    public void run() {
        MyService7.printA();
    }
}
