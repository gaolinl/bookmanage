package com.example.demo.service;/**
 * Created by gaolin on 2019/7/31.
 */

import com.alibaba.druid.util.DaemonThreadFactory;
import com.example.demo.mapper.BookInfoMapper;
import com.example.demo.pojo.BookInfo;
import com.example.demo.pojo.Record;
import com.example.demo.util.JWTToken;
import com.example.demo.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * @author gaolin
 * @create 2019-07-31 16:37
 **/
@Service
public class BookService {

    @Autowired
    private BookInfoMapper mapper;

    //查询书籍
    public Result selectBook(BookInfo bookInfo){
        Result result = new Result();

        return null;
    }

    //插入书籍
    @Transactional
    public Result insertBook(BookInfo bookInfo,HttpServletRequest httpServletRequest){
        Result result = new Result();
        Date date = new Date();
        bookInfo.setBookCreateTime(date);
        bookInfo.setBookUpdateTime(date);
        bookInfo.setCreateUser(JWTToken.getLoginName(httpServletRequest));
        List<BookInfo> bookList = new ArrayList<BookInfo>();
        if(bookInfo.getNum()!=0){
            String groupId = getUUID();
            for(int i = 0;i<bookInfo.getNum();i++){
                BookInfo book = new BookInfo(bookInfo.getBookName(),bookInfo.getBookType(),bookInfo.getAuthor(),bookInfo.getPrice(),
                        bookInfo.getPublisher(),bookInfo.getBookCreateTime(),bookInfo.getBookUpdateTime(),bookInfo.getCreateUser(),
                        bookInfo.getUpdateUser(),bookInfo.getPicture(),bookInfo.getDesc());
                book.setGroupId(groupId);
                bookList.add(book);
            }
            mapper.insert(bookList);
            bookInfo.setBookIsbn("IN56SD");
            bookInfo.setGroupId(groupId);
            mapper.updateBookIsbn(bookInfo);
        }
        result.setCode(10000);
        result.setMsg("新增图书成功");
        return result;
    }

    /**
     * 获得一个UUID
     * @return String UUID
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }

    //多条件查询书籍信息
    public Result selectBookInfo(BookInfo bookInfo,Integer pageSize,Integer pageNum){
        PageHelper.startPage(pageNum,pageSize);
        Result result = new Result();
        List<BookInfo> list = mapper.selectAll(bookInfo);
        PageInfo<BookInfo> pageInfo = new PageInfo<BookInfo>(list);
        int index = 0;
        for(BookInfo book: list){
            String groupId = book.getGroupId();
            book = bookInfo;
            book.setGroupId(groupId);
            list.get(index).setBorrowNum(mapper.selectBorrowNum(book));
            index++;
        }
        result.setData(pageInfo);
        result.setCode(10000);
        result.setMsg("书籍信息查询成功！");
        return result;
    }

    //查询组内的所有书籍信息
    public Result selectBookByGroup(BookInfo bookInfo){
        List<BookInfo> list = mapper.selectBookByGroup(bookInfo);
        Result result = new Result();
        result.setData(list);
        result.setMsg("分组查询详细信息成功");
        result.setCode(10000);
        return result;
    }

    //批量更新书籍的基本信息
    public Result updateBookInfo(BookInfo bookInfo,HttpServletRequest httpServletRequest){
        Date date = new Date();
        bookInfo.setBookUpdateTime(date);
        bookInfo.setUpdateUser(JWTToken.getLoginName(httpServletRequest));
        int flag = mapper.updateBookInfo(bookInfo);
        Result result = new Result();
        result.setCode(10000);
        result.setMsg("更新书籍的基本信息成功");
        result.setData(flag);
        return result;
    }

    //根据书籍编号单个更新书籍信息
    public Result updateBookStatusById(BookInfo bookInfo,HttpServletRequest request){
        Result result = new Result();
        Date date = new Date();
        bookInfo.setBookUpdateTime(date);
        bookInfo.setUpdateUser(JWTToken.getLoginName(request));
        mapper.updateBookStatusById(bookInfo);
        result.setCode(10000);
        result.setMsg("更新书籍信息成功");
        return result;
    }


}
