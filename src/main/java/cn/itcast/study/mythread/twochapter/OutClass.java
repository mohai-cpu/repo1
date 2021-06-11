package cn.itcast.study.mythread.twochapter;

public class OutClass {
    static class Inner{
        public void methOd1(){
            synchronized ("其他的锁") {
                for (int i = 1;i<=10;i++){
                    System.out.println(Thread.currentThread().getName()+"i="+i);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        public synchronized void method2(){
            for (int i = 11;i<=20;i++){
                System.out.println(Thread.currentThread().getName()+"i="+i);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
