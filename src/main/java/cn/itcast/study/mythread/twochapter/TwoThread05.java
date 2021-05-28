package cn.itcast.study.mythread.twochapter;

public class TwoThread05 extends Thread {
    private MyObject2 object;

    public TwoThread05(MyObject2 object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
