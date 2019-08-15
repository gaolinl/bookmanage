package com.example.demo.mapper;

import com.example.demo.pojo.BookInfo;
import com.example.demo.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(List<BookInfo> record);

    BookInfo selectByPrimaryKey(Integer bookId);

    List<BookInfo> selectAll(BookInfo bookInfo);
    //统计已经借出的书籍数量
    Integer selectBorrowNum(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

    int updateBookIsbn(BookInfo record);

    //根据分组的id查询该组内的所有书籍
    List<BookInfo> selectBookByGroup(BookInfo bookInfo);

    //更新书籍的基本信息
    int updateBookInfo(BookInfo bookInfo);

    //批量更新书籍的状态
    int updateBookStatus(List<BookInfo> list);

    //根据借阅记录的书籍编号更新单个书籍状态
    int updateBookStatusOne(Record record);

    //根据书籍id更新书籍信息
    int updateBookStatusById(BookInfo bookInfo);

}