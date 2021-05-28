package cn.itcast.study.mythread.twochapter;

public class MyObject {
    synchronized public void methodA(){
        try{
            System.out.println("begin methodA threadNmae=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
