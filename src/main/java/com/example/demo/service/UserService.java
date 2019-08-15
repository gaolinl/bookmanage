package com.example.demo.service;/**
 * Created by gaolin on 2019/7/25.
 */

import com.example.demo.BiliSpringboot03Application;
import com.example.demo.mapper.BookUserMapper;
import com.example.demo.pojo.BookUser;
import com.example.demo.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpResponse;
import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.text.ParseException;
import java.util.*;

/**
 * @author gaolin
 * @create 2019-07-25 11:23
 **/
@Service
public class UserService {

    Logger log= LoggerFactory.getLogger(BiliSpringboot03Application.class);
    @Autowired
    private BookUserMapper userMapper;

    public Result addUser(BookUser user){
        BookUser userList = (BookUser) judgeUserUnique(user).getData();
        int unique=0;
        if(userList!=null){
            unique = 1;
        }
        Result result = new Result();
        if(unique==1){
            Date date = new Date();
            user.setCreateTime(date);
            user.setUpdateTime(date);
            if(user.getBalance()==0){
                user.setBalance(50.0);
            }
            if(user.getPassword()==null || user.getPassword().equals("")){
                user.setPassword("123");
            }
            int flag = userMapper.insert(user);
            if(flag == 1){
                result.setCode(Code.success.getValue());
                result.setMsg("新增成功！");
            }else{
                result.setCode(Code.ERROR_ADD_USER.getValue());
                result.setMsg("新增失败！");
            }
        }else {
            result.setCode(10003);
            result.setMsg("用户名不唯一");
        }
        return result;
    }

    //判断登录名唯一
    public Result judgeUserUnique(BookUser user){
        BookUser userList = userMapper.selectByPrimaryKey(user.getLoginName());
        Result result = new Result();
        result.setData(userList);
        return result;
    }

    public Result login(BookUser user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Boolean flag = checkCode(request,user);
        System.out.println("验证码输入正确"+flag);
        Result result = new Result();
        if (!flag){
            result.setMsg("验证码不正确");
            return result;
        }
        BookUser bookUser = userMapper.selectLoginInfo(user);
        if(bookUser != null){
            String token = JWTToken.createToken(user.getLoginName());
            Cookie cookie = new Cookie("token",token);
            cookie.setPath(request.getServletContext().getContextPath());
            System.out.println(cookie.getPath());
            response.addCookie(cookie);
            result.setData(bookUser);
            result.setCode(Code.success.getValue());
        }else{
            Cookie cookie = new Cookie("token","");
            response.addCookie(cookie);
            result.setCode(Code.NULL_OBJ.getValue());
        }
        return result;
    }

    public Result reOut(BookUser user,HttpServletResponse response){
        Cookie cookie = new Cookie("token","");
        response.addCookie(cookie);
        Result result = new Result();
        result.setMsg("注销成功");
        return result;
    }

    public Result selectUser(BookUser user,Integer pageSize,Integer pageNum) throws ParseException {
        //分页组件
        PageHelper.startPage(pageNum,pageSize);
        //前端传的最近登录时间条件数组
        List timeList = user.getLastLoginTimeList();
        if(!CollectionUtils.isEmpty(timeList)){
            String startTime = timeList.get(0).toString();
            String endTime = timeList.get(1).toString();
            user.setStartTime(GetDateFormat.getDateFormat(startTime));
            user.setEndTime(GetDateFormat.getDateFormat(endTime));
        }
        System.out.println("mapper----"+user);
        List<BookUser> userList = userMapper.selectAll(user);
        PageInfo<BookUser> pageInfo = new PageInfo<BookUser>(userList);
        Result result = new Result();
        result.setCode(Code.success.getValue());
        result.setData(pageInfo);
        return result;
    }

    //获取验证码
    public Result getCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        VerificationCode code = new VerificationCode();
        //获取验证码图片
        BufferedImage image = code.getImage();
        //获取验证码内容
        String codeText = code.getText();
        HttpSession session = request.getSession();
        session.setAttribute("singCode",codeText);
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
//        ServletOutputStream sos = response.getOutputStream();
//        ImageIO.write(image,"jpeg",sos);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image,"jpeg",baos);
        byte[] bytes = baos.toByteArray();
        String base64 = new BASE64Encoder().encode(bytes).trim();
//        sos.flush();
//        sos.close();
        Map<String,String> map =  new HashMap<>();
        map.put("base64",base64);
        Result result = new Result();
        result.setData(map);
        return result;
    }

    //检验验证码是否正确
    public Boolean checkCode(HttpServletRequest request,BookUser user){
        HttpSession session = request.getSession();
        String sessionCode = (String)session.getAttribute("singCode");
        System.out.println("code in session---"+sessionCode);
        if(user.getCode()== null){
            return false;
        }
        if(user.getCode().equalsIgnoreCase(sessionCode)){
            return true;
        }
        return false;
    }

    //更新用户信息
    public Result updateBookUser(BookUser user){
        BookUser userList = (BookUser) judgeUserUnique(user).getData();
        Date date = new Date();
        user.setUpdateTime(date);
        Result result = new Result();
        if(userList.getId().equals(user.getId())){
            Integer flag = userMapper.updateByPrimaryKey(user);
            if(flag==1){
                result.setCode(10000);
                result.setMsg("更新用户信息成功");
            }else {
                result.setCode(10001);
                result.setMsg("更新用户失败");
            }
        }else {
            result.setCode(10003);
            result.setMsg("该登录名已经存在");
        }
        return result;
    }

    //删除用户信息
    public Result deleteUserInfo(BookUser user){
        Result result = new Result();
        Integer flag = userMapper.deleteByPrimaryKey(user.getId());
        if(flag==1){
            result.setCode(10000);
            result.setMsg("删除成功");
        }else {
            result.setCode(10002);
            result.setMsg("删除失败");
        }
        return result;
    }

}
