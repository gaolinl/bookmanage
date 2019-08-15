package com.example.demo.mapper;

import com.example.demo.pojo.BookUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookUser record);

    BookUser selectByPrimaryKey(String loginName);

    BookUser selectLoginInfo(BookUser user);

    List<BookUser> selectAll(BookUser user);

    int updateByPrimaryKey(BookUser record);
}