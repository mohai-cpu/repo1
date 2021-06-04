package cn.itcast.study.mythread.twochapter;

public class TwoThread15 extends Thread {
    private ObjectService2 service2;

    public TwoThread15(ObjectService2 service2) {
        this.service2 = service2;
    }

    @Override
    public void run() {
        super.run();
        service2.serviceMethodA();
    }
}
