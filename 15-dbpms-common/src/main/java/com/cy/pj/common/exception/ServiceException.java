package com.cy.pj.common.exception;
/**
 * 自定义业务层异常 (一般是继承RuntimeException)
 * 通过自定义异常，对项目中业务业务异常进行更好的定位和分析
 */
public class ServiceException extends RuntimeException{
    public ServiceException() {
    }
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
