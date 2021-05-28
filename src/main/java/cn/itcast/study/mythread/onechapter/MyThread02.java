package cn.itcast.study.mythread.onechapter;

public class MyThread02 extends Thread{
    @Override
    public void run() {
        super.run();
        /*try{
            for(int i=0;i<10;i++){
                int time = (int)(Math.random()*1000);
                Thread.sleep(time);
                System.out.println("睡眠线程="+Thread.currentThread().getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/

    }
}
