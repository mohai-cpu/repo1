package cn.itcast.study.mythread.twochapter;

import cn.itcast.study.controller.TokenController;

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
    /*public static void main(String[] args) {
        MyService4 service4 = new MyService4();
        TwoThread21 thread21 = new TwoThread21(service4);
        thread21.setName("a");
        thread21.start();
        TwoThread22 thread22 = new TwoThread22(service4);
        thread22.setName("b");
        thread22.start();
    }*/
   /* public static void main(String[] args) {
        MyList myList = new MyList();
        TwoThread23 thread23 = new TwoThread23(myList);
        thread23.setName("A");
        thread23.start();
        TwoThread24 thread24 = new TwoThread24(myList);
        thread24.setName("B");
        thread24.start();
    }*/
   /* public static void main(String[] args) {
        try {
            MyOneList list = new MyOneList();
            TwoThread25 thread25 = new TwoThread25(list);
            thread25.setName("A");
            thread25.start();
            TwoThread26 thread26 = new TwoThread26(list);
            thread26.setName("B");
            thread26.start();
            Thread.sleep(6000);
            System.out.println("listSize="+list.getSize());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
   /* public static void main(String[] args) {
        MyService6 service6 = new MyService6();
        MyObject object = new MyObject();
        TwoThread27 thread27 = new TwoThread27(service6,object);
        thread27.setName("a");
        thread27.start();
        TwoThread28 thread28 = new TwoThread28(service6,object);
        thread28.setName("b");
        thread28.start();
    }*/
    /*public static void main(String[] args) {
        MyService6 service6 = new MyService6();
        MyObject object1 = new MyObject();
        MyObject object2 = new MyObject();
        TwoThread27 thread27 = new TwoThread27(service6,object1);
        thread27.setName("a");
        thread27.start();
        TwoThread28 thread28 = new TwoThread28(service6,object2);
        thread28.setName("b");
        thread28.start();
    }*/
   /* public static void main(String[] args) {
        TwoThread29 thread29 = new TwoThread29();
        thread29.setName("A");
        thread29.start();
        TwoThread30 thread30 = new TwoThread30();
        thread30.setName("B");
        thread30.start();
    }*/
    /*public static void main(String[] args) {
        MyService8 service8 = new MyService8();
        TwoThread31 a = new TwoThread31(service8);
        a.setName("A");
        a.start();
        TwoThread32 b = new TwoThread32(service8);
        b.setName("B");
        b.start();
        TwoThread32 c = new TwoThread32(service8);
        c.setName("C");
        c.start();
    }*/
    /*public static void main(String[] args) {
        MyService9 service9 = new MyService9();
        TwoThread34 a = new TwoThread34(service9);
        a.setName("A");
        a.start();
        TwoThread35 b = new TwoThread35(service9);
        b.setName("B");
        b.start();
    }*/
    public static void main(String[] args) {
        MyService10 service10 = new MyService10();
        TwoThread36 thread36 = new TwoThread36(service10);
        thread36.setName("A");
        thread36.start();
        TwoThread37 thread37 = new TwoThread37(service10);
        thread37.setName("B");
        thread37.start();
    }
}
