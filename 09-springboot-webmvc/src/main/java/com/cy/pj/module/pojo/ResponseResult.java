package com.cy.pj.module.pojo;
/**服务端响应对象设计*/
public class ResponseResult {//alt+insert 选择生成set和get等方法
    /**状态码*/
    private Integer code;
    /**响应信息*/
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
