package cn.itcast.study.mythread.twochapter;

public class TwoThread09 extends Thread {
    private Task task;

    public TwoThread09(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        CommonUtils.beginTime1 = System.currentTimeMillis();
        System.out.println("shgua="+CommonUtils.beginTime1);
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
        System.out.println("shddgua="+CommonUtils.endTime1);
    }
}
