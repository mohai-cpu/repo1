package cn.itcast.study.mythread.twochapter;

public class MyService2 {
   synchronized public void testMethod(){
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("ThreadName="+Thread.currentThread().getName()
            +"run beginTime="+System.currentTimeMillis());
            int i = 1;
            while (i == 1){
                if((""+Math.random()).substring(0,8).equals("0.123456")){
                    System.out.println("ThreadName="+Thread.currentThread().getName()
                    +"run exceptionTime="+System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        }else{
            System.out.println("Thread B run time ="+System.currentTimeMillis());
        }
    }
}
