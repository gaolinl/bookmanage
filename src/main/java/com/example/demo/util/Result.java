package com.example.demo.util;/**
 * Created by gaolin on 2019/7/25.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaolin
 * @create 2019-07-25 11:26
 **/
public class Result<T> {
    /**
    * code码
    */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
