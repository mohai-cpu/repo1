package cn.itcast.study.mythread;

public class MyThread13 extends Thread {
    @Override
    public void run() {
        super.run();
        try{
            System.out.println("run begin");
            Thread.sleep(100000);
            System.out.println("run end");
        }catch (Exception e){
            System.out.println("在沉睡中被停止！进入catch！"+this.isInterrupted());
            e.printStackTrace();
        }
    }
}
