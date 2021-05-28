package cn.itcast.study.mythread.twochapter;

public class RunTest01 {
    /*public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        TwoThread01 thread01 = new TwoThread01(numRef);
        thread01.start();
        TwoThread02 thread02 = new TwoThread02(numRef);
        thread02.start();
    }*/
   /* public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
        TwoThread01 thread01 = new TwoThread01(numRef);
        thread01.start();
        TwoThread02 thread02 = new TwoThread02(numRef2);
        thread02.start();
    }*/
    /*public static void main(String[] args) {
        MyObject object = new MyObject();
        TwoThread03 twoThread03 = new TwoThread03(object);
        twoThread03.setName("a");
        TwoThread04 twoThread04 = new TwoThread04(object);
        twoThread04.setName("b");
        twoThread03.start();
        twoThread04.start();
    }*/
    public static void main(String[] args) {
        MyObject2 object = new MyObject2();
        TwoThread05 twoThread05 = new TwoThread05(object);
        twoThread05.setName("a");
        TwoThread06 twoThread06 = new TwoThread06(object);
        twoThread06.setName("b");
        twoThread06.start();
        twoThread06.start();
    }
}
