package cn.itcast.study.mythread;

public class MyThread11 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            if (this.interrupted()) {
                System.out.println("已经停止了，我要退出");
                break;
            }
            System.out.println("i=" + (i + 1));
        }
        System.out.println("我被输出，如果此代码是for又继续运行，线程并停止！");
    }
}
