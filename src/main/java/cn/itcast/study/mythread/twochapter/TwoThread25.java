package cn.itcast.study.mythread.twochapter;

public class TwoThread25 extends Thread {
    private MyOneList list;

    public TwoThread25(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        MyService5 msRef = new MyService5();
        msRef.addServiceMethod(list,"A");
    }
}
