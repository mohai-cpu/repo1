package cn.itcast.study.mythread.twochapter;

public class TwoThread14 extends Thread {
    private Task3 task3;

    public TwoThread14(Task3 task3) {
        this.task3 = task3;
    }

    @Override
    public void run() {
        super.run();
        task3.doLongTimeTask();
    }
}
