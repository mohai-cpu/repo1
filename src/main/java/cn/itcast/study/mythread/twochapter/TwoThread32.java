package cn.itcast.study.mythread.twochapter;

public class TwoThread32 extends Thread {
    private MyService8 service8;

    public TwoThread32(MyService8 service8) {
        this.service8 = service8;
    }

    @Override
    public void run() {
        service8.printB();
    }
}
