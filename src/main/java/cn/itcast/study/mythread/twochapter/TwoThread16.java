package cn.itcast.study.mythread.twochapter;

public class TwoThread16 extends Thread {
    private ObjectService2 service2;

    public TwoThread16(ObjectService2 service2) {
        this.service2 = service2;
    }

    @Override
    public void run() {
        super.run();
        service2.serviceMethodB();
    }
}
