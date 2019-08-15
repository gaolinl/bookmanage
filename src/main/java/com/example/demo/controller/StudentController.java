package com.example.demo.controller;/**
 * Created by gaolin on 2019/7/17.
 */

import com.example.demo.entity.Student;
import com.example.demo.exception.MyException;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.util.Code;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaolin
 * @create 2019-07-17 15:58
 **/
@Api(value="学生管理")
@RestController
@RequestMapping("Student")
public class StudentController {
    @Autowired
    private StudentMapper mapper;

    @RequestMapping(value = "/selectStudent",method = RequestMethod.POST)
    @ApiOperation(value = "测试swagger")
    public Student selectStudent(Integer id){
        throw new MyException(Code.ERROR_ADD_USER);
//        return mapper.getStudent(id);
    }
}
