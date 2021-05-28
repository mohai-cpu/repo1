package cn.itcast.study.mythread.onechapter;

public class MyThread04 extends Thread{
    private int count = 5;
    public MyThread04(String name){
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0){
            count --;
            System.out.println("由"+this.currentThread().getName()+"计算，count="+count);
        }
    }
}
