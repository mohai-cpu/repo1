package cn.itcast.study.mythread.twochapter;

public class TwoThread28 extends Thread {
    private MyService6 service6;
    private MyObject object;

    public TwoThread28(MyService6 service6, MyObject object) {
        this.service6 = service6;
        this.object = object;
    }
    @Override
    public void run(){
       service6.testMethod1(object);
    }
}
