package cn.itcast.study.utils;


import java.io.Serializable;

/**
 * @author Administrator
 * @Title: ReturnResult
 * @ProjectName day02spring
 * @Description: 统一返回数据封装
 * @date 2020/9/29
 */
public class ReturnResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
