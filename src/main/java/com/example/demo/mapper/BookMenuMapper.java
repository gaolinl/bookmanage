package com.example.demo.mapper;

import com.example.demo.pojo.BookMenu;
import java.util.List;

public interface BookMenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(BookMenu record);

    BookMenu selectByPrimaryKey(Integer menuId);

    List<BookMenu> selectAll();

    int updateByPrimaryKey(BookMenu record);
}