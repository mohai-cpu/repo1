package cn.itcast.study.mythread.twochapter;

public class TwoThread38 extends Thread{
    volatile public static int count;
    private static void addCount(){
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count="+count);
    }

    @Override
    public void run() {
        addCount();
    }
}
