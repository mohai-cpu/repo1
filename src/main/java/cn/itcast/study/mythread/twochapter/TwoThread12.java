package cn.itcast.study.mythread.twochapter;

public class TwoThread12 extends Thread{
    public ObjectService service;

    public TwoThread12(ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceMethod();
    }
}
