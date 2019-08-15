package com.example.demo.entity;/**
 * Created by gaolin on 2019/7/17.
 */

/**
 * @author gaolin
 * @create 2019-07-17 15:51
 **/
public class Student {
    Integer id;
    Integer age;
    String name;

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
