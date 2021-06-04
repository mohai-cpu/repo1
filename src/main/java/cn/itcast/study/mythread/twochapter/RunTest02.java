package cn.itcast.study.mythread.twochapter;

import cn.itcast.study.mythread.onechapter.MyThread09;
import cn.itcast.study.mythread.onechapter.MyThread10;

public class RunTest02 {
   /* public static void main(String[] args) {
        try{
            PublicVar publicVar = new PublicVar();
            TwoThread07 thread07 = new TwoThread07(publicVar);
            thread07.start();
            Thread.sleep(2000);//打印结果收到此值大小影响
            publicVar.getValue();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
   /*public static void main(String[] args) {
       TwoThread08 thread08 = new TwoThread08();
       thread08.start();
   }*/
   /*public static void main(String[] args) {
       try{
           MyService2 service2 = new MyService2();
           TwoThreadA twoThreadA = new TwoThreadA(service2);
           twoThreadA.setName("a");
           twoThreadA.start();
           TwoThreadB twoThreadB = new TwoThreadB(service2);
           twoThreadB.setName("b");
           twoThreadB.start();
       }catch (Exception e){
           e.printStackTrace();
       }
   }*/
   /*public static void main(String[] args) {
       Sub subRef = new Sub();
       TwoThreadAA a = new TwoThreadAA(subRef);
       a.setName("A");
       a.start();
       TwoThreadBB b = new TwoThreadBB(subRef);
       b.setName("B");
       b.start();
   }*/
   /*public static void main(String[] args) {
       Task task = new Task();
       TwoThread09 thread09 = new TwoThread09(task);
       thread09.start();
       TwoThread10 thread10 = new TwoThread10(task);
       thread10.start();
       System.out.println("***************begin=" + CommonUtils.beginTime1);
       System.out.println("***************end="+CommonUtils.endTime2);
       try {
            Thread.sleep(10000);
       }catch (Exception e){
           e.printStackTrace();
       }
       long beginTime = CommonUtils.beginTime1;
       if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
           beginTime = CommonUtils.beginTime2;
       }
       long endTime = CommonUtils.endTime1;
       if(CommonUtils.endTime2>CommonUtils.endTime1){
           endTime =CommonUtils.endTime2;
       }
       System.out.println(endTime);
       System.out.println(beginTime);
       System.out.println("耗时:"+(endTime-beginTime)/1000);
   }*/
   /*public static void main(String[] args) {
       ObjectService service = new ObjectService();
       TwoThread11 a = new TwoThread11(service);
       a.setName("a");
       a.start();
       TwoThread12 b = new TwoThread12(service);
       b.setName("b");
       b.start();
   }*/
   /*public static void main(String[] args) {
       Task3 task3 = new Task3();
       TwoThread13 twoThread13 = new TwoThread13(task3);
       twoThread13.start();
       TwoThread14 twoThread14 = new TwoThread14(task3);
       twoThread14.start();
   }*/
   public static void main(String[] args) {
       ObjectService2 service2 = new ObjectService2();
       TwoThread16 thread16 =new TwoThread16(service2);
       thread16.setName("a");
       thread16.start();
       TwoThread15 thread15 = new TwoThread15(service2);
       thread15.start();
   }
}
