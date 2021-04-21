package cn.itcast.study.mythread.threaddemo.maintest;

import cn.itcast.study.mythread.threaddemo.demotest.*;
import com.alibaba.fastjson.JSONObject;

public class MainTest01 {
    /*public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.start();
        ThreadB threadB = new ThreadB();
        threadB.start();
    }*/
    /*public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread thread = new Thread(countOperate);
        thread.setName("A");
        thread.start();
    }*/
    /*public static void main(String[] args) {
        System.out.println("main thread begin priority="+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority=" + Thread.currentThread().getPriority());
        Thread01 thread01 = new Thread01();
        thread01.start();
    }*/
    /*public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread03 thread03 = new Thread03();
            thread03.setPriority(1);
            thread03.start();
            Thread04 thread04 = new Thread04();
            thread04.setPriority(10);
            thread04.start();
        }
    }*/
   /* public static void main(String[] args) {
        try{
            Thread05 thread05 = new Thread05();
            thread05.setDaemon(true);
            thread05.start();
            Thread.sleep(5000);
            System.out.println("我离开thread对象也不再打印了，也就是停止了！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args) {
        String uri = "/aaa/b/ll";
        String s = uri.replaceAll("f", "/");
        System.out.println(s+"***************");
        String[] split = uri.split("/");
        System.out.println(split.length);
        System.out.println(JSONObject.toJSONString(split));
    }
}
