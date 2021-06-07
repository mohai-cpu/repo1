package cn.itcast.study.mythread.twochapter;

public class TwoThread23 extends Thread {
    private MyList list;

    public TwoThread23(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            list.add("Thread23"+(i+1));
        }
    }
}
