package cn.itcast.study.mythread.twochapter;

public class TwoThread24 extends Thread {
    private MyList list;

    public TwoThread24(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            list.add("Thread24"+(i+1));
        }
    }
}
