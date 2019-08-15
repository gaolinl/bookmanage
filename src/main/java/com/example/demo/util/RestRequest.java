package com.example.demo.util;/**
 * Created by gaolin on 2019/7/19.
 */

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @author gaolin
 * @create 2019-07-19 16:16
 **/
public class RestRequest<T> implements Serializable{
    private static final long serialVersionUID = -1296515585582912062L;
    @Valid
    private T body = null;

    private int pageSize;
    private int pageNum;
    public RestRequest() {
    }

    public RestRequest(T body) {
        this.body = body;
    }

    public static <T> RestRequest<T> instance(T body) {
        return new RestRequest(body);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public T getBody() {
        return this.body;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setBody(T body) {
        this.body = body;
    }


    protected boolean canEqual(Object other) {
        return other instanceof RestRequest;
    }
}
