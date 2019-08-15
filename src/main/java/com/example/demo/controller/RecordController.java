package com.example.demo.controller;/**
 * Created by gaolin on 2019/8/9.
 */

import com.example.demo.pojo.BookInfo;
import com.example.demo.pojo.Record;
import com.example.demo.pojo.SelectBo;
import com.example.demo.service.RecordService;
import com.example.demo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * @author gaolin
 * @create 2019-08-09 14:53
 **/
@Api("借阅记录")
@RestController
@RequestMapping("book")
public class RecordController {

    @Autowired
    private RecordService service;

    @ApiOperation("添加借阅记录")
    @RequestMapping(value = "/user/addRecord",method = RequestMethod.POST)
    public Result addBorrowRecord(@RequestBody Record record, HttpServletRequest request){
        return service.insertRecord(record,request);
    }

    @ApiOperation("查询借阅记录")
    @RequestMapping(value = "/user/getRecord",method = RequestMethod.POST)
    public Result getRecord(@RequestBody SelectBo<BookInfo> bo, HttpServletRequest request){
        return service.selectRecordBookInfoDetail(bo.getEntity(),bo.getPageNum(),bo.getPageSize(),request);
    }

    //更新借阅信息
    @ApiOperation("更新借阅信息")
    @RequestMapping(value = "/user/updateRecord",method = RequestMethod.POST)
    public Result updateRecord(@RequestBody Record record,HttpServletRequest request){
        return service.updateRecordStaus(record,request);
    }

    //查询借阅记录信息
    @ApiOperation("查询借阅记录信息")
    @RequestMapping(value = "/user/selectRecord")
    public Result selectRecord(@RequestBody SelectBo<Record> bo,HttpServletRequest request) throws ParseException {
        return service.selectRecord(bo.getEntity(),bo.getPageNum(),bo.getPageSize(),request);
    }

    //查询借阅记录对应的明细信息
    @ApiOperation("查询借阅记录对应的明细信息")
    @RequestMapping(value = "/user/selectRecordDetail",method = RequestMethod.POST)
    public Result selectRecordDetail(@RequestBody Record record){
        return service.selectRecordDetail(record);
    }
}
