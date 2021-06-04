package cn.itcast.study.mythread.twochapter;

public class TwoThread10 extends Thread {
    private Task task;

    public TwoThread10(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}
