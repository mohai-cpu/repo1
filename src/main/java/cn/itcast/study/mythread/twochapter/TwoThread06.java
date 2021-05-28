package cn.itcast.study.mythread.twochapter;

public class TwoThread06 extends Thread {
    private MyObject2 object;

    public TwoThread06(MyObject2 object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}
