package cn.itcast.study.mythread.twochapter;

public class ObjectService2 {
    public void serviceMethodA(){
        try{
            synchronized (this){
                System.out.println("A begin time="+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end time="+System.currentTimeMillis());
            }
        }catch(Exception e){

        }
    }
    public void serviceMethodB(){
        synchronized (this){
            System.out.println("B begin time="+System.currentTimeMillis());
            System.out.println("B end time="+System.currentTimeMillis());
        }
    }
}
