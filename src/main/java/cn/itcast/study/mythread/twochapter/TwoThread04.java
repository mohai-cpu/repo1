package cn.itcast.study.mythread.twochapter;

public class TwoThread04 extends Thread {
    private MyObject object;

    public TwoThread04(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
