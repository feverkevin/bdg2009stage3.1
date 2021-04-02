package com.cy.pj.arithmetic.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * @RestControllerAdvice 描述的类，为spring mvc中的全局异常处理类，
 * 当某个控制层对象方法出现了异常，方法内部没有处理异常，方法所在的类
 * 也没有定义处理此异常的方法，此时系统底层会查找全局异常处理类，并检测
 * 这个全局处理类中是否定义了可以处理此异常方法，假如定义了，则直接调用
 * 异常处理方法处理异常。
 */
//@ControllerAdvice
//@ResponseBody
@RestControllerAdvice //@ControllerAdvice+@ResponseBody
public class GlobalExceptionHandler {

//    @ExceptionHandler(ArithmeticException.class)
//    //@ResponseBody 当类上添加了@ResponseBody，方法上的就可以省略了
//    public String doHandleArithmeticException(ArithmeticException e){
//        //....记录日志.....
//        return "GlobalExceptionHandler.doHandleArithmeticException's exception msg is "+e.getMessage();
//    }//此异常处理方法，可以处理这个方法所在类的所有算术异常。

    @ExceptionHandler(RuntimeException.class)
    //@ResponseBody 当类上添加了@ResponseBody，方法上的就可以省略了
    public String doHandleRuntimeException(RuntimeException e){
        //....记录日志.....
        return "GlobalExceptionHandler.doHandleRuntimeException's exception msg is "+e.getMessage();
    }
}
//重点：将来在项目中建议定义全局异常处理类，在类中定义对应的异常处理方法