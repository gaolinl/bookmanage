package com.example.demo.controller;/**
 * Created by gaolin on 2019/7/15.
 */

import com.example.demo.entity.Student;
import com.example.demo.exception.MyException;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

/**
 * @author gaolin
 * @create 2019-07-15 9:34
 **/
@RestController
@RequestMapping(value = "student")
public class LoginController {


    @RequestMapping(value = "/login")
    public String login(@RequestBody Student student){

        return "ooooo";
    }

}
