package com.example.demo.pojo;/**
 * Created by gaolin on 2019/8/1.
 */


import io.swagger.models.auth.In;

/**
 * @author gaolin
 * @create 2019-08-01 13:54
 **/
public class SelectBo<T> {
    private T entity;
    private Integer pageNum;
    private Integer pageSize;
    private Object o;
    public T getEntity() {
        return entity;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "SelectBo{" +
                "entity=" + entity +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", o=" + o +
                '}';
    }
}
