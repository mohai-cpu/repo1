package cn.itcast.study.mythread.twochapter;

public class TwoThread07 extends Thread {
    private PublicVar publicVar;

    public TwoThread07(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B","BB");
    }
}
