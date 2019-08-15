package com.example.demo.mapper;

import com.example.demo.pojo.BookInfo;
import com.example.demo.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by gaolin on 2019/8/9.
 */
@Mapper
public interface BookRecordMapper {

    //插入借阅记录
    int insertBorrowRecord(Record record);

    //插入借阅记录明细表
    int insertBorrowDetail(List<BookInfo> list);

    //借阅记录信息查询
    List<Record> selectBorrowDetail(BookInfo bookInfo);

    //更新借阅明细书籍的状态
    int updateDetailStatus(Record record);

    //更新借阅记录表中已还书的数量
    int updateRecordReturnNum(Record record);

    //查询借阅记录
    List<Record> selectBorrowRecord(Record record);

    //查询借阅记录对应的明细信息
    List<Record> selectBorrowRecordDetail(Record record);

}
