package com.example.demo.mapper;

import com.example.demo.pojo.BookRole;
import java.util.List;

public interface BookRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(BookRole record);

    BookRole selectByPrimaryKey(Integer roleId);

    List<BookRole> selectAll();

    int updateByPrimaryKey(BookRole record);
}