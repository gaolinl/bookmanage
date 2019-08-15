package com.example.demo.util;/**
 * Created by gaolin on 2019/7/25.
 */

/**
 * @author gaolin
 * @create 2019-07-25 11:53
 **/
public enum Code {
    success(10000,"成功"),
    NULL_OBJ(10001,"对象为空"),
    ERROR_ADD_USER(10002,"添加用户失败"),
    ERROR_PWD(10003,"账号密码不对");

    private Integer value;
    private String desc;

    private Code(Integer value, String desc) {
        this.setValue(value);
        this.setDesc(desc);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "[" + this.value + "]" + this.desc;
    }
}
