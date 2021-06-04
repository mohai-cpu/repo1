package cn.itcast.study.mythread.twochapter;

public class ObjectService {
    public void serviceMethod(){
        try{
            //同步代码块
           synchronized (this){
               System.out.println("begin time=" + System.currentTimeMillis());
               Thread.sleep(2000);
               System.out.println("end end="+System.currentTimeMillis());
           }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
