package com.example.demo.service;/**
 * Created by gaolin on 2019/8/9.
 */

import com.example.demo.mapper.BookInfoMapper;
import com.example.demo.mapper.BookRecordMapper;
import com.example.demo.pojo.BookInfo;
import com.example.demo.pojo.Record;
import com.example.demo.util.GetDateFormat;
import com.example.demo.util.JWTToken;
import com.example.demo.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author gaolin
 * @create 2019-08-09 14:34
 **/
@Service
public class RecordService {
    @Autowired
    private BookRecordMapper mapper;

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Transactional
    //插入借阅信息:借阅表、借阅明细表
    public Result insertRecord(Record record, HttpServletRequest request){
        List<BookInfo> list = record.getList();
        Date date = new Date();
        record.setBorrowTime(date);
        record.setLoginName(JWTToken.getLoginName(request));
        record.setBorrowNum(list.size());
        //插入借阅表
        mapper.insertBorrowRecord(record);
        for(BookInfo bookInfo:list){
            bookInfo.setBorrowRecordId(record.getId());
            bookInfo.setBorrowUser(record.getLoginName());
            bookInfo.setBorrowDate(date);
            bookInfo.setStatus("借出");
        }
        //更新书籍状态
        bookInfoMapper.updateBookStatus(list);
        //插入借阅明细表
        mapper.insertBorrowDetail(list);
        System.out.println(list);
        Result result = new Result();
        result.setCode(10000);
        result.setMsg("插入借阅记录信息成功");
        return result;
    }

    //查询书籍借阅记录明细
    public Result selectRecordBookInfoDetail(BookInfo bookInfo,Integer pageNum,Integer pageSize, HttpServletRequest request){
        PageHelper.startPage(pageNum,pageSize);
        bookInfo.setBorrowUser(JWTToken.getLoginName(request));
        List<Record> list = mapper.selectBorrowDetail(bookInfo);
        PageInfo<Record> pageInfo = new PageInfo<Record>(list);
        Result result = new Result();
        result.setData(pageInfo);
        result.setCode(10000);
        result.setMsg("查询借阅详细信息成功");
        return result;
    }

    //归还图书：更新书籍状态
    @Transactional
    public Result updateRecordStaus(Record record,HttpServletRequest request){
        Date date = new Date();
        record.setReturnTime(date);
        //更新明细表书籍借阅状态
        mapper.updateDetailStatus(record);
        //更新图书表书籍状态
        bookInfoMapper.updateBookStatusOne(record);
        //更新记录表已还书的数量
        mapper.updateRecordReturnNum(record);
        Result result = new Result();
        result.setCode(10000);
        result.setMsg("更新书籍信息成功");
        return result;
    }

    //查询借阅记录表
    public Result selectRecord(Record record,Integer pageNum,Integer pageSize,HttpServletRequest request) throws ParseException {
        //角色为2，代表是普通用户，则需要查找该登录人的借阅记录
        if(record.getRoleId()==2){
            record.setLoginName(JWTToken.getLoginName(request));
        }
        //前端传的借阅时间条件数组
        List timeList = record.getBorrowTimeList();
        if(!CollectionUtils.isEmpty(timeList)){
            String startTime = timeList.get(0).toString();
            String endTime = timeList.get(1).toString();
            record.setStartTime(GetDateFormat.getDateFormat(startTime));
            record.setEndTime(GetDateFormat.getDateFormat(endTime));
        }

        PageHelper.startPage(pageNum,pageSize);
        Result result = new Result();
        List<Record> list = mapper.selectBorrowRecord(record);
        PageInfo<Record> pageInfo = new PageInfo<Record>(list);
        result.setData(pageInfo);
        result.setCode(10000);
        result.setMsg("查询借阅记录信息成功！");
        return result;
    }

    //查询借阅记录对应的明细信息
    public Result selectRecordDetail(Record record){
        Result result = new Result();
        List<Record> list = mapper.selectBorrowRecordDetail(record);
        result.setData(list);
        result.setCode(10000);
        result.setMsg("查询借阅记录对应的明细信息成功！");
        return result;
    }
}
