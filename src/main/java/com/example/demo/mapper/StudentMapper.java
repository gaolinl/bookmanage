package com.example.demo.mapper;/**
 * Created by gaolin on 2019/7/17.
 */

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author gaolin
 * @create 2019-07-17 15:54
 **/
@Mapper
public interface StudentMapper {
    @Select("select * from student where id = #{id}")
    public Student getStudent(Integer id);
}
