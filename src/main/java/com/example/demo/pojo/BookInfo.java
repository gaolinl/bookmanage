package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BookInfo {
    private Integer id;

    private String bookIsbn;

    private String bookName;

    private String bookType;

    private String author;

    private Double price;

    private String publisher;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date bookCreateTime;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date bookUpdateTime;

    private String createUser;

    private String updateUser;

    private Integer num;

    private String picture;

    private String desc;

    private String groupId;

    private String status;

    private Integer borrowNum;

    //借阅人
    private String borrowUser;

    //借阅记录id
    private Integer borrowRecordId;

    //借阅时间
    private Date borrowDate;

    public BookInfo() {
    }

    public BookInfo(String bookName, String bookType, String author, Double price, String publisher, Date bookCreateTime, Date bookUpdateTime, String createUser, String updateUser, String picture, String desc) {
        this.bookName = bookName;
        this.bookType = bookType;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.bookCreateTime = bookCreateTime;
        this.bookUpdateTime = bookUpdateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.picture = picture;
        this.desc = desc;
    }

    public Integer getBorrowRecordId() {
        return borrowRecordId;
    }

    public void setBorrowRecordId(Integer borrowRecordId) {
        this.borrowRecordId = borrowRecordId;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public String getBorrowUser() {
        return borrowUser;
    }

    public void setBorrowUser(String borrowUser) {
        this.borrowUser = borrowUser;
    }

    public void setBorrowNum(Integer borrowNum) {
        this.borrowNum = borrowNum;
    }

    public Integer getBorrowNum() {
        return borrowNum;
    }

    public Integer getNum() {
        return num;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getPicture() {
        return picture;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setBookId(Integer bookId) {
        this.id = bookId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn == null ? null : bookIsbn.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType == null ? null : bookType.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Date getBookCreateTime() {
        return bookCreateTime;
    }



    public void setBookCreateTime(Date bookCreateTime) {
        this.bookCreateTime = bookCreateTime;
    }

    public Date getBookUpdateTime() {
        return bookUpdateTime;
    }

    public void setBookUpdateTime(Date bookUpdateTime) {
        this.bookUpdateTime = bookUpdateTime;
    }

    public Integer getId() {
        return id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }
    @Override
    public String toString() {
        return "BookInfo{" +
                "id=" + id +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookType='" + bookType + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publisher='" + publisher + '\'' +
                ", bookCreateTime=" + bookCreateTime +
                ", bookUpdateTime=" + bookUpdateTime +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", num=" + num +
                ", picture='" + picture + '\'' +
                ", desc='" + desc + '\'' +
                ", groupId='" + groupId + '\'' +
                ", status='" + status + '\'' +
                ", borrowNum=" + borrowNum +
                ", borrowUser=" + borrowUser +
                ", borrowRecordId=" + borrowRecordId +
                ", borrowDate=" + borrowDate +
                '}';
    }
}