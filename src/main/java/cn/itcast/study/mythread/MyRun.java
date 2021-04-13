package cn.itcast.study.mythread;

public class MyRun {
    /*public static void main(String[] args) {
        MyThread01 thread01 = new MyThread01();
        thread01.start();
        System.out.println("运行结束！");
    }*/
    /*public static void main(String[] args) {
        try{
            MyThread2 thread2 = new MyThread2();
            thread2.setName("thread2");
            thread2.start();
            for(int i=0;i<10;i++){
                int time = (int)(Math.random()*1000);
                Thread.sleep(time);
                System.out.println("main="+Thread.currentThread().getName());
            }
        }catch (Exception e){
           e.printStackTrace();
        }
    }*/
   /* public static void main(String[] args) {
        MyThread03 thread01 = new MyThread03(1);
        MyThread03 thread02 = new MyThread03(2);
        MyThread03 thread03 = new MyThread03(3);
        MyThread03 thread04 = new MyThread03(4);
        MyThread03 thread05 = new MyThread03(5);
        MyThread03 thread06 = new MyThread03(6);
        MyThread03 thread07 = new MyThread03(7);
        MyThread03 thread08 = new MyThread03(8);
        MyThread03 thread09 = new MyThread03(9);
        MyThread03 thread010 = new MyThread03(10);

        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
        thread06.start();
        thread07.start();
        thread08.start();
        thread09.start();
        thread010.start();
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }*/
    public static void main(String[] args) {
       /* MyThread04 a = new MyThread04("A");
        MyThread04 b = new MyThread04("B");
        MyThread04 c = new MyThread04("C");
        a.start();
        b.start();
        c.start();*/
       /*MyThread05 thread05 = new MyThread05();
       Thread a = new Thread(thread05,"A");
        Thread b = new Thread(thread05,"B");
        Thread c = new Thread(thread05,"C");
        Thread d = new Thread(thread05,"D");
        Thread e = new Thread(thread05,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();*/

       /* MyThread06 thread06 = new MyThread06();
        Thread a = new Thread(thread06,"A");
        Thread b = new Thread(thread06,"B");
        Thread c = new Thread(thread06,"C");
        Thread d = new Thread(thread06,"D");
        Thread e = new Thread(thread06,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();*/
       MyThread07 thread07 = new MyThread07();  //主线程main
       thread07.start();  //新开启的线程
       thread07.run();  //主线程main  只是调用了一个方法
    }
}
