package cn.itcast.study.mythread.twochapter;

public class MyService6 {
    public void testMethod1(MyObject object){
        synchronized (object){
            try {
                System.out.println("testMethod1_getLock time="+System.currentTimeMillis()+"run ThreadName="+
                        Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod1 releaseLock time="+System.currentTimeMillis()+"run ThreadName="+
                        Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
