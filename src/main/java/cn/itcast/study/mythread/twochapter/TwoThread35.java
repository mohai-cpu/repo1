package cn.itcast.study.mythread.twochapter;

public class TwoThread35 extends Thread {
    private MyService9 service9;

    public TwoThread35(MyService9 service9) {
        this.service9 = service9;
    }

    @Override
    public void run() {
        service9.print("AA");
    }
}
