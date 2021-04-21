package cn.itcast.study.mythread;

public class MyThread09 extends Thread{
    @Override
    public void run() {
        try{
            System.out.println("run threadname"+this.currentThread().getName()+"begin");
            Thread.sleep(2000);
            System.out.println("run threadname"+this.currentThread().getName()+"end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
