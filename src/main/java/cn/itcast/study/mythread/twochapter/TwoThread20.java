package cn.itcast.study.mythread.twochapter;

public class TwoThread20 extends Thread{
    private MyService3 service3;

    public TwoThread20(MyService3 service3) {
        this.service3 = service3;
    }

    @Override
    public void run() {
        service3.setUsernamePassword("b","bb");
    }
}
