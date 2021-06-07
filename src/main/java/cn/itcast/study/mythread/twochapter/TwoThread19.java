package cn.itcast.study.mythread.twochapter;

public class TwoThread19 extends Thread{
    private MyService3 service3;

    public TwoThread19(MyService3 service3) {
        this.service3 = service3;
    }

    @Override
    public void run() {
        service3.setUsernamePassword2("a","aa");
    }
}
