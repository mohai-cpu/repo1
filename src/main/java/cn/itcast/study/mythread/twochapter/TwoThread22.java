package cn.itcast.study.mythread.twochapter;

public class TwoThread22 extends Thread{
    private MyService4 service4;

    public TwoThread22(MyService4 service4) {
        this.service4 = service4;
    }

    @Override
    public void run() {
        service4.b();
    }
}
