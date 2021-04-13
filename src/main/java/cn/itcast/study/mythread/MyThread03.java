package cn.itcast.study.mythread;

public class MyThread03 extends Thread {
    private int i;
    public MyThread03(int i){
        super();
        this.i=i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
