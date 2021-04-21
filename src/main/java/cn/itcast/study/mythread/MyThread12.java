package cn.itcast.study.mythread;

public class MyThread12 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println("已经停止了，我要退出");
                    throw new Exception("异常退出");
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("我被输出，如果此代码是for又继续运行，线程并停止！");
        } catch (Exception e) {
            System.out.println("看看是否进入异常");
            e.printStackTrace();
        }
    }
}
