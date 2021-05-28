package cn.itcast.study.mythread.demotest;

public class ThreadB extends Thread{
    @Override
    public void run() {
        LoginService loginService = new LoginService();
        loginService.doLogin("lisi","123456789");
    }
}
