package cn.itcast.study.dto;

import cn.itcast.study.constant.InformationEnum;

public class Test {
    public static void main(String[] args) {
        String phone = "13222222222";
        String s = phone.replaceAll(phone.substring(0, 3), "***");
        System.out.println(s);
        System.out.println("测试成功");
        String code = InformationEnum.FOUCS_NEWS.getCode();
        String msg = InformationEnum.FOUCS_NEWS.getMsg();
        System.out.println(code+"="+msg);
    }
}
