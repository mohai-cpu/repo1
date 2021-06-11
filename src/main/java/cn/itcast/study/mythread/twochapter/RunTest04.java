package cn.itcast.study.mythread.twochapter;


public class RunTest04 {
    /*public static void main(String[] args) {
        try{
            DealThread t1 = new DealThread();
            t1.setFlag("a");
            Thread thread1 = new Thread(t1);
            thread1.start();
            Thread.sleep(100);
            t1.setFlag("b");
            Thread thread2 = new Thread(t1);
            thread2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
    /*public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("user");
        publicClass.setPassword("123");
        System.out.println(publicClass.getUsername()+""+publicClass.getPassword());
        PublicClass.PrivateClass privateClass = publicClass.new PrivateClass();
        privateClass.setAge("18");
        privateClass.setAddress("你好");
        System.out.println(privateClass.getAge()+""+privateClass.getAddress());
    }*/
    /*public static void main(String[] args) {
        final OutClass.Inner inner = new OutClass.Inner();
        Thread t1 = new Thread(new Runnable(){

            @Override
            public void run() {
                inner.methOd1();
            }
        },"A");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method2();
            }
        },"B");
        t1.start();
        t2.start();
    }*/
    /*public static void main(String[] args) {
        PrintString printString = new PrintString();
        printString.printStringMethod();
        System.out.println("我要停止它！ stopThread=" + Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }*/
    /*public static void main(String[] args) {
        PrintString printString = new PrintString();
        Thread t = new Thread(printString);
        t.start();
        System.out.println("我要停止它！ stopThread=" + Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }*/
    /*public static void main(String[] args) {
        try{
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("已经赋值为false");
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
    /*public static void main(String[] args) {
        TwoThread38[] thread38s = new TwoThread38[100];
        for (int i = 0; i < 100; i++) {
            thread38s[i] = new TwoThread38();
        }
        for (int i = 0; i < 100; i++) {
            thread38s[i].start();
        }
    }*/
   /* public static void main(String[] args) {
        AddCountThread countThread = new AddCountThread();
        Thread t1 = new Thread(countThread);
        t1.start();
        Thread t2 = new Thread(countThread);
        t2.start();
        Thread t3 = new Thread(countThread);
        t3.start();
        Thread t4 = new Thread(countThread);
        t4.start();
        Thread t5 = new Thread(countThread);
        t5.start();
    }*/
    public static void main(String[] args) {
        try{
            MyService11 service11 = new MyService11();
            TwoThread39[] thread39s = new TwoThread39[5];
            for (int i = 0; i < thread39s.length; i++) {
                thread39s[i] = new TwoThread39(service11);
            }
            for (int i = 0; i < thread39s.length; i++) {
                thread39s[i].start();
            }
            Thread.sleep(1000);
            System.out.println(service11.atomicLong.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
