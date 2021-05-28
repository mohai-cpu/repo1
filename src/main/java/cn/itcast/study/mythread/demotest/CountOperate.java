package cn.itcast.study.mythread.demotest;

public class CountOperate extends Thread {
    public CountOperate(){
        System.out.println("CountOperate------begin");
        System.out.println("构造name="+Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
        System.out.println("thisgouzao="+this.getName());
        System.out.println("this.isAlive()="+this.isAlive());
        System.out.println("CountOperate------end");
    }

    @Override
    public void run() {
        System.out.println("run------begin");
        System.out.println("run的name="+Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() run="+Thread.currentThread().isAlive());
        System.out.println("thisgouzaorunde="+this.getName());
        System.out.println("this.isAlive() run="+this.isAlive());
        System.out.println("run------end");
    }
}
