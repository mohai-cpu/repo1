package cn.itcast.study.mythread.twochapter;

public class TwoThread39 extends Thread {
    private MyService11 service11;

    public TwoThread39(MyService11 service11) {
        this.service11 = service11;
    }

    @Override
    public void run() {
       service11.addNum();
    }
}
