package cn.itcast.study.mythread.twochapter;

public class TwoThread01 extends Thread {
    private HasSelfPrivateNum numRef;

    public TwoThread01(HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        numRef.addI("a");
    }
}
