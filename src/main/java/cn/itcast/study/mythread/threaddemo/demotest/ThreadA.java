package cn.itcast.study.mythread.threaddemo.demotest;

public class ThreadA extends Thread {
    @Override
    public void run() {
        LoginService loginService = new LoginService();
        loginService.doLogin("zhangsan","123456");
    }
}
