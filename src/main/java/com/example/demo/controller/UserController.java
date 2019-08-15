package com.example.demo.controller;/**
 * Created by gaolin on 2019/7/25.
 */

import com.example.demo.pojo.BookUser;
import com.example.demo.pojo.SelectBo;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaolin
 * @create 2019-07-25 14:58
 **/
@Api("用户管理")
@RequestMapping("book")
@RestController
public class UserController {
    @Autowired
    private UserService service;

    @ApiOperation("新增用户")
    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public Result addUser(@RequestBody BookUser user){
        return service.addUser(user);
    }

    @ApiOperation("判断用户的唯一性")
    @RequestMapping(value = "/user/judge",method = RequestMethod.POST)
    public Result judgeUnique(@RequestBody BookUser user){
        return service.judgeUserUnique(user);
    }

    @ApiOperation("用户登录")
    @RequestMapping(value="/user/login",method = RequestMethod.POST)
    public Result login(@RequestBody BookUser user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return service.login(user,request,response);
    }

    @ApiOperation("用户查询")
    @RequestMapping(value="/user/selectUser",method = RequestMethod.POST)
    public Result selectUser(@RequestBody SelectBo<BookUser> bo) throws Exception {
        System.out.println(bo);
        return service.selectUser(bo.getEntity(),bo.getPageSize(),bo.getPageNum());
    }

    @ApiOperation("用户注销")
    @RequestMapping(value="/user/reOut",method = RequestMethod.POST)
    public Result out(@RequestBody BookUser user, HttpServletResponse response) throws Exception {
        return service.reOut(user,response);
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/user/getCode",method = RequestMethod.POST)
    public Result getCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        return service.getCode(request,response);
    }

    @ApiOperation("更新用户信息")
    @RequestMapping(value = "/user/updateUser",method = RequestMethod.POST)
    public Result updateUserInfo(@RequestBody BookUser user){
        return service.updateBookUser(user);
    }

    @ApiOperation("删除用户信息")
    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
    public Result deleteuserInfo(@RequestBody BookUser user){
        return service.deleteUserInfo(user);
    }

}
