package cn.itcast.study.mythread.twochapter;

public class TwoThread02 extends Thread {
    private HasSelfPrivateNum numRef;

    public TwoThread02(HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        numRef.addI("b");
    }
}
