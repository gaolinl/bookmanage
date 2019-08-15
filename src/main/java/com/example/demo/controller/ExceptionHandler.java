package com.example.demo.controller;/**
 * Created by gaolin on 2019/7/15.
 */

import com.example.demo.exception.MyException;
import org.omg.CORBA.Object;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.SunHints;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaolin
 * @create 2019-07-15 15:07
 * 异常处理器
 * 自定义异常处理器
 **/
@ControllerAdvice
public class ExceptionHandler {


    //浏览器和客户端返回的都是json类型的数据
//    @org.springframework.web.bind.annotation.ExceptionHandler(MyException.class)
//    @ResponseBody
//    public Map<String,String> handleException(Exception e){
//        Map<String,String> map = new HashMap<>();
//        map.put("code","401");
//        map.put("msg","自定义异常信息，可以忽略");
//        return map;
//    }

    //
//    @org.springframework.web.bind.annotation.ExceptionHandler(MyException.class)
    @ResponseBody
    public String handleException(Exception e, HttpServletRequest request){
        //转发springmvc给它/error请求
        return "forward:/error";
    }

}
