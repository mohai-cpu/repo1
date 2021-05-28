package cn.itcast.study.mythread.onechapter;

public class MyThread05 extends Thread{
    private int count = 5;
    @Override
    public void run() {
        super.run();
        while (count > 0){
            count --;
            System.out.println("由"+this.currentThread().getName()+"计算，count="+count);
        }
    }
}
