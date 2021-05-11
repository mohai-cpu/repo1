package cn.itcast.study.demotest;

import cn.itcast.study.utils.ReturnResult;
import com.alibaba.fastjson.JSONObject;

import java.util.Random;

public class test01 {
    /*public static void main(String[] args) {
        Demo01.test01();
        System.out.println(Demo01.i);
        System.getProperties().list(System.out);
        Random random = new Random();
       // random.nextInt(100);
        System.out.println(random.nextInt(100));
    }*/
    public static void main(String[] args) {
        ReturnResult returnResult = null;
        if (returnResult == null || returnResult.getCode() == 2000) {
            System.out.println("******************");
        }
        System.out.println(JSONObject.toJSONString(returnResult));
    }


    public Long getresult(){
        int i = 10/0;
        long result = new Random().nextInt(100);
        System.out.println("result1=" + result);
        return result;
    }
}
