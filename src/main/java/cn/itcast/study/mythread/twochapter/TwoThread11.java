package cn.itcast.study.mythread.twochapter;

public class TwoThread11 extends Thread {
    private ObjectService service;

    public TwoThread11(ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.serviceMethod();
    }
}
