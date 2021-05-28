package cn.itcast.study.mythread.twochapter;

public class TwoThread03 extends Thread {
    private MyObject object;

    public TwoThread03(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
