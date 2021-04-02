package com.cy.pj.common.web;

import com.cy.pj.common.pojo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**异常处理方式定义*/
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult doHandleRuntimeException(RuntimeException e){
         log.error("exception is "+e.getMessage());
         return new ResponseResult(e);//封装异常结果
        //当返回值是一个pojo对象或map时，系统底层会调用jackson api将对象转换为json格式字符串
        //请问：
        //1)pojo对象转换为json串时，有什么条件?(提供get方法)
        //2)pojo对象转换为json串时，json串中的key与类中属性相同？不一定
        //3)map对象转换为json串时，json串中的key与map中的key相同吗？相同
        //4)响应结果为什么我们要转换为json格式的串呢？(跨端，解析方便)
    }
}
