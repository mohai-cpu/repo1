package cn.itcast.study.mythread.twochapter;

public class TwoThread33 extends Thread {
    private MyService8 service8;

    public TwoThread33(MyService8 service8) {
        this.service8 = service8;
    }

    @Override
    public void run() {
        service8.printC();
    }
}
