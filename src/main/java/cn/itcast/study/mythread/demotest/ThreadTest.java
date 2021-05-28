package cn.itcast.study.mythread.demotest;

public class ThreadTest {
   /* public static void main(String[] args) {
        try {
            Thread06 thread06 = new Thread06();
            thread06.start();
            Thread.sleep(2000);
            thread06.interrupt();
            System.out.println("是否停止1="+thread06.interrupted());
            System.out.println("是否停止2="+thread06.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }*/
   /*public static void main(String[] args) {
       Thread.currentThread().interrupt();
       System.out.println("是否停止1="+Thread.interrupted());
       System.out.println("是否停止2="+Thread.interrupted());
       System.out.println("end");
   }*/

   /* public static void main(String[] args) {
        try {
            Thread06 thread06 = new Thread06();
            thread06.start();
            Thread.sleep(2000);
            thread06.interrupt();
            System.out.println("是否停止1="+thread06.isInterrupted());
            System.out.println("是否停止2="+thread06.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }*/
   /*public static void main(String[] args) {
       try {
           Thread07 thread07 = new Thread07();
           thread07.start();
           Thread.sleep(200);
           thread07.interrupt();
       } catch (InterruptedException e) {
           System.out.println("main catch");
           e.printStackTrace();
       }
       System.out.println("end");
   }*/
  /* public static void main(String[] args) {
       try {
           Thread08 thread08 = new Thread08();
           thread08.start();
           Thread.sleep(5000);
           //A
           thread08.suspend();
           System.out.println("A="+System.currentTimeMillis()+"i="+thread08.getI());
           Thread.sleep(5000);
           System.out.println("A="+System.currentTimeMillis()+"i="+thread08.getI());
           //B
           thread08.resume();
           Thread.sleep(5000);
           //C
           thread08.suspend();
           System.out.println("B="+System.currentTimeMillis()+"i="+thread08.getI());
           Thread.sleep(5000);
           System.out.println("B="+System.currentTimeMillis()+"i="+thread08.getI());
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }*/
  /* public static void main(String[] args) {
       Thread09 thread09 = new Thread09();
       thread09.start();
   }*/
   /*public static void main(String[] args) {
       System.out.println("main thread begin priority="+Thread.currentThread().getPriority());
       Thread.currentThread().setPriority(6);
       System.out.println("main thread end prioriority="+Thread.currentThread().getPriority());
       Thread10 thread10 = new Thread10();
       thread10.start();
   }*/
   /*public static void main(String[] args) {
       for (int i = 0; i < 5; i++) {
           Thread12 thread12 = new Thread12();
           thread12.setPriority(10);
           thread12.start();
           Thread13 thread13 = new Thread13();
           thread13.setPriority(1);
           thread13.start();
       }
   }*/
   /*public static void main(String[] args) {
       try {
           Thread14 thread14 = new Thread14();
           thread14.setDaemon(true);//设置成守护线程
           thread14.start();
           Thread.sleep(5000);
           System.out.println("我离开thread对象也不再打印了，也就是停止了！");
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }*/
}
