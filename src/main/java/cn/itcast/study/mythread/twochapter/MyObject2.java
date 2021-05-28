package cn.itcast.study.mythread.twochapter;

public class MyObject2 {
    synchronized public void methodA(){
        try{
            System.out.println("begin methodA threadNmae=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end endTime="+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void methodB(){
        try{
            System.out.println("begin methodB threadName=" + Thread.currentThread().getName() + "begin time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
