package cn.itcast.study.mythread.twochapter;

import java.security.Provider;

public class TwoThread27 extends Thread {
    private MyService6 service6;
    private MyObject object;

    public TwoThread27(MyService6 service6, MyObject object) {
        this.service6 = service6;
        this.object = object;
    }
    @Override
    public void run(){
       service6.testMethod1(object);
    }
}
