package cn.itcast.study.mythread.twochapter;

public class TwoThreadA extends Thread {
    private MyService2 myService2;

    public TwoThreadA(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        myService2.testMethod();
    }
}
