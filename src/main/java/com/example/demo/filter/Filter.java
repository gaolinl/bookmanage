package com.example.demo.filter;/**
 * Created by gaolin on 2019/7/28.
 */

import com.example.demo.util.JWTToken;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gaolin
 * @create 2019-07-28 11:20
 **/
public class Filter extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        System.out.println("前置拦截器1 preHandle： 请求的uri为："+requestURL.toString());
        Cookie[] cookies = httpServletRequest.getCookies();
        String token = "";
        if(cookies.length!=0){
            for(Cookie c:cookies){
                if(c.getName().equals("token")){
                    token = c.getValue();
                }
            }
            System.out.println(token);
            Boolean flag = JWTToken.verifyJudgeToken(token);
            if(!flag){
                System.out.println("token验证不存在");
            }else{
                System.out.println("token验证成功");
            }
            return flag;
        }else{
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("拦截器1 postHandle： ");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        System.out.println("拦截器1 afterCompletion： ");
    }
}
