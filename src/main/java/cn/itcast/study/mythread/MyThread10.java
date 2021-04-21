package cn.itcast.study.mythread;

public class MyThread10 extends Thread {
    @Override
    public void run() {
        try{
            System.out.println("run name=" + this.currentThread().getName() + "begin=" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("run name="+this.currentThread().getName()+"end="+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
