package cn.itcast.study.mythread.twochapter;

import java.util.concurrent.atomic.AtomicLong;

public class MyService11 {
    public static AtomicLong atomicLong = new AtomicLong();
    synchronized public void addNum(){
        System.out.println(Thread.currentThread().getName()+"加了100之后的值是："+atomicLong.addAndGet(100));
        atomicLong.addAndGet(1);
    }
}
