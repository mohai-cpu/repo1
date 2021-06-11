package cn.itcast.study.mythread.twochapter;

public class TwoThread34 extends Thread {
    private MyService9 service9;

    public TwoThread34(MyService9 service9) {
        this.service9 = service9;
    }

    @Override
    public void run() {
        service9.print("AA");
    }
}
