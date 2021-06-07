package cn.itcast.study.mythread.twochapter;

public class RunTest03 {
    /*public static void main(String[] args) {
        try {
            Task4 task4 = new Task4();
            TwoThread17 thread17 = new TwoThread17(task4);
            thread17.start();
            Thread.sleep(100);
            TwoThread18 thread18 = new TwoThread18(task4);
            thread18.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }*/
   /* public static void main(String[] args) {
        MyService3 service3 = new MyService3();
        TwoThread19 thread19 = new TwoThread19(service3);
        thread19.setName("A");
        thread19.start();
        TwoThread20 thread20 = new TwoThread20(service3);
        thread20.setName("B");
        thread20.start();
    }*/
    public static void main(String[] args) {
        MyService4 service4 = new MyService4();
        TwoThread21 thread21 = new TwoThread21(service4);
        thread21.setName("a");
        thread21.start();
        TwoThread22 thread22 = new TwoThread22(service4);
        thread22.setName("b");
        thread22.start();
    }
}
