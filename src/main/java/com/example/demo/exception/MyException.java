package com.example.demo.exception;/**
 * Created by gaolin on 2019/7/15.
 */

/**
 * @author gaolin
 * @create 2019-07-15 14:32
 **/
public class MyException extends RuntimeException {
    public MyException(Object obj){
        super(obj.toString());
    }
}
