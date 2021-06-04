package cn.itcast.study.mythread.twochapter;
//测试同步不可以继承
public class Main {
    synchronized public void serviceMethod(){
        try{
            System.out.println("int main 下一步 sleep begin threadName =" + Thread.currentThread().getName() + "time=" + System.currentTimeMillis());
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
