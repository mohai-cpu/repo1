package cn.itcast.study.demotest;

import java.util.Random;

public class test01 {
    public static void main(String[] args) {
        Demo01.test01();
        System.out.println(Demo01.i);
        System.getProperties().list(System.out);
        Random random = new Random();
       // random.nextInt(100);
        System.out.println(random.nextInt(100));
    }
}
