package cn.itcast.study.mythread;

public class MyRun2 {
    /*public static void main(String[] args) {
        MyThread08 thread08 = new MyThread08();
        System.out.println("begin == "+thread08.isAlive());
        thread08.start();
        *//*try {
            Thread.sleep(1000);//主线程休眠1秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*//*
        System.out.println("end=="+thread08.isAlive());
    }*/
    /*public static void main(String[] args) {
        MyThread09 thread09 = new MyThread09();
        System.out.println("begin=" + System.currentTimeMillis());
        thread09.run();
        System.out.println("end="+System.currentTimeMillis());
    }*/
    /*public static void main(String[] args) {
        MyThread10 thread10 = new MyThread10();
        System.out.println("begin="+System.currentTimeMillis());
        thread10.start();
        System.out.println("end="+System.currentTimeMillis());
    }*/
    /*public static void main(String[] args) {
        MyThread08 thread08 = new MyThread08();
        System.out.println(thread08.getName()+" "+thread08.getId());
        Thread runth = Thread.currentThread();
        System.out.println(runth.getName()+" "+runth.getId());
    }*/
    /*public static void main(String[] args) {
        try{
            MyThread01 thread01 = new MyThread01();
            thread01.start();
            Thread.sleep(1000);
            thread01.interrupt();
            System.out.println("是否停止1="+thread01.interrupted());
            System.out.println("是否停止2="+thread01.interrupted());
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
   /* public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1="+Thread.interrupted());
        System.out.println("是否停止2="+Thread.interrupted());
        System.out.println("end!");
    }*/
    public static void main(String[] args) {
        try {
            MyThread02 thread02 = new MyThread02();
            thread02.start();
            Thread.sleep(1000);
            thread02.interrupt();
            System.out.println("是否停止1=" + thread02.isInterrupted());
            System.out.println("是否停止2=" + thread02.isInterrupted());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end******");
    }
}
