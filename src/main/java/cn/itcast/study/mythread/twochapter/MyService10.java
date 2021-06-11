package cn.itcast.study.mythread.twochapter;

public class MyService10 {
    public static void print(Object object){
        try{
            synchronized (object){
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
