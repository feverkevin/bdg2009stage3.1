package com.cy.pj.module.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**通过此对象封装请求中的参数数据*/
public class RequestParameter {

    public RequestParameter(){
        System.out.println("RequestParameter()");
    }
    private String name;

    public Date getStartDate() {
        return startDate;
    }

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    //@DateTimeFormat 注解可以描述pojo对象中的属性，set方法，controller类中的日期类型的方法参数
    //当使用pojo对象请求请求参数时,@DateTimeFormat用于设置接收请求参数中指定格式的日期参数
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    //.......

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RequestParameter{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
