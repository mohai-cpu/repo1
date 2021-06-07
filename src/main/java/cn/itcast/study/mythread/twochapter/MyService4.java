package cn.itcast.study.mythread.twochapter;

public class MyService4 {
    private String anyString = new String();
    public void a(){
        synchronized (anyString){
            try{
                System.out.println("a begin");
                Thread.sleep(3000);
                System.out.println("a end");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public synchronized void b(){
        System.out.println("b begin");
        System.out.println("b end");
    }
}
