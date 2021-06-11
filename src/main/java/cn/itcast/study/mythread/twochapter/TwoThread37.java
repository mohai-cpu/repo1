package cn.itcast.study.mythread.twochapter;

public class TwoThread37 extends Thread {
    private MyService10 servic10;

    public TwoThread37(MyService10 servic10) {
        this.servic10 = servic10;
    }

    @Override
    public void run() {
        servic10.print(new Object());
    }

}
