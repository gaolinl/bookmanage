package com.example.demo.pojo;/**
 * Created by gaolin on 2019/8/9.
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;

import java.util.Date;
import java.util.List;

/**
 * @author gaolin
 * @create 2019-08-09 10:11
 * 借阅dto
 **/
public class Record {
    //入参书籍list
    private List<BookInfo> list;

    //主键id
    private Integer id;

    //借书人
    private String loginName;

    //一次借书的数量
    private Integer borrowNum;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date borrowTime;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date returnTime;

    private String bookIsbn;

    private String status;

    //已还数量
    private Integer returnNumber;

    //借阅记录id
    private Integer borrowRecordId;

    //罚款金额
    private double amercement;

    //图书名
    private String bookName;

    //角色id
    private Integer roleId;

    private String bookType;
    private String author;
    private double price;
    private String publisher;
    private String desc;
    private String picture;
    private List borrowTimeList;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List getBorrowTimeList() {
        return borrowTimeList;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setBorrowTimeList(List borrowTimeList) {
        this.borrowTimeList = borrowTimeList;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setList(List<BookInfo> list) {
        this.list = list;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDesc() {
        return desc;
    }

    public String getPicture() {
        return picture;
    }

    public String getStatus() {
        return status;
    }

    public Integer getReturnNumber() {
        return returnNumber;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReturnNumber(Integer returnNumber) {
        this.returnNumber = returnNumber;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Integer getBorrowRecordId() {
        return borrowRecordId;
    }

    public void setBorrowRecordId(Integer borrowRecordId) {
        this.borrowRecordId = borrowRecordId;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getBorrowNum() {
        return borrowNum;
    }

    public void setAmercement(double amercement) {
        this.amercement = amercement;
    }

    public void setBorrowNum(Integer borrowNum) {
        this.borrowNum = borrowNum;
    }

    public List<BookInfo> getList() {
        return list;
    }

    public String getLoginName() {
        return loginName;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmercement() {
        return amercement;
    }

    @Override
    public String toString() {
        return "Record{" +
                "list=" + list +
                ", id=" + id +
                ", loginName='" + loginName + '\'' +
                ", borrowNum=" + borrowNum +
                ", borrowTime=" + borrowTime +
                ", returnTime=" + returnTime +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", status='" + status + '\'' +
                ", returnNumber=" + returnNumber +
                ", borrowRecordId=" + borrowRecordId +
                ", amercement=" + amercement +
                ", bookName='" + bookName + '\'' +
                ", roleId=" + roleId +
                ", bookType='" + bookType + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publisher='" + publisher + '\'' +
                ", desc='" + desc + '\'' +
                ", picture='" + picture + '\'' +
                ", borrowTimeList=" + borrowTimeList +
                ", endTime=" + endTime +
                ", startTime=" + startTime +
                '}';
    }
}
