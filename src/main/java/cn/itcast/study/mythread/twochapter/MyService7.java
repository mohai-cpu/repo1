package cn.itcast.study.mythread.twochapter;

public class MyService7 {
    synchronized public static void printA(){
        try{
            System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printA");
            Thread.sleep(3000);
            System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printA");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
