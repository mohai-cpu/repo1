package cn.itcast.study.mythread.onechapter;

public class MyThread14 extends Thread {
    @Override
    public void run() {
        super.run();
        try{
            for (int i = 0; i <100000 ; i++) {
                System.out.println(i);
            }
            System.out.println("run begin");
            Thread.sleep(100000);
            System.out.println("run end");
        }catch (Exception e){
            System.out.println("先停止！在sleep，进入catch！");
            e.printStackTrace();
        }
    }
}
