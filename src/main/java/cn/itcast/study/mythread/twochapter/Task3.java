package cn.itcast.study.mythread.twochapter;

public class Task3 {
    public void doLongTimeTask(){
        for (int i = 0; i < 100; i++) {
            System.out.println("nosynchronized threadName=" + Thread.currentThread().getName() + "i=" + (i + 1));
            System.out.println("");
            synchronized (this){
                for (int j = 0; j <100 ; j++) {
                    System.out.println("synchronized threadName="+Thread.currentThread().getName()+"j="+(j+1));
                }
            }
        }
    }
}
