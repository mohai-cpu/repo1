package cn.itcast.study.mythread.twochapter;

public class TwoThread26 extends Thread {
    private MyOneList list;

    public TwoThread26(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        MyService5 msRef = new MyService5();
        msRef.addServiceMethod(list,"B");
    }
}
