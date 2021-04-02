package com.cy.pj.common.pojo;

/**
 * 服务端响应到客户端的结果对象设计。
 * 为什么要写这个对象？响应数据的标准化，便于客户端对数据进行处理。
 * 服务端响应到客户端的数据如何归类？正常还是异常
 * 1)正常数据
 * 2)异常数据
 * 客户端如何识别服务端响应到客户端的数据是正常数据还是异常数据呢？（状态）
 * 服务端响应的结果数据应该有一个状态。
 */
public class ResponseResult {
    private static final int SUCCESS=1;
    private static final int ERROR=0;
    /**响应数据状态*/
    private Integer state=SUCCESS;//1 success,0 exception
    /**状态对应的信息*/
    private String message="ok";
    /**服务端响应到客户端的查询结果*/
    private Object data;

    public ResponseResult(){}
    public ResponseResult(String message){//state=1,message="delete ok"
        this.message=message;
    }
    public ResponseResult(Object data){
        this.data=data;
    }
    public ResponseResult(Throwable e){//出现异常以后可以执行此方法
        this.state=ERROR;
        this.message=e.getMessage();
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
