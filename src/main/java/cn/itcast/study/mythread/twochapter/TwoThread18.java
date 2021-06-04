package cn.itcast.study.mythread.twochapter;

public class TwoThread18 extends Thread{
    private Task4 task4;

    public TwoThread18(Task4 task4) {
        this.task4 = task4;
    }

    @Override
    public void run() {
        super.run();
        task4.doLongTimeTask();
    }
}
