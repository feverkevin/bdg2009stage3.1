package com.cy.pj.arithmetic.controller;

import org.springframework.web.bind.annotation.*;

@RestController //@Controller+@ReponseBody
public class ArithmeticController extends BaseController{
    /**除法运算*/
    @RequestMapping("/doDivCompute01/{n1}/{n2}")
    public String doDivCompute01(@PathVariable  Integer n1, @PathVariable Integer n2){
         try {
            Integer result = n1 / n2;
            return "result is "+result;
         }catch (ArithmeticException e){//ArithmeticException is a RuntimeException
            return "do compute error,cause by "+e.getMessage();
         }//try{}catch(){}代码我们在项目中通常会认为模板代码
         //将来在项目中不建议出现大量重复的模板代码
    }
    @RequestMapping("/doDivCompute02/{n1}/{n2}")
    public String doDivCompute02(@PathVariable  Integer n1, @PathVariable Integer n2){
            Integer result = n1 / n2;
            //如上语句出现了算数以后以后，此异常会抛给谁？调用方，调用方是谁呢？DispatcherServlet
            return "result is "+result;
    }

    /**
     * @ExceptionHandler  注解描述的方法为控制逻辑层异常处理方法，此注解内部
     * 定义的异常类型，为异常处理方法可以处理的异常类型
     * 其中，异常处理方法参数中的异常类型应该与@ExceptionHandler注解中定义的异常类型
     * 一致或者是@ExceptionHandler注解中定义的异常类型的父类类型
     * @param e 为异常处理方法捕获到的异常对象
     * @return
     */
//    @ExceptionHandler(ArithmeticException.class)
//    //@ResponseBody 当类上添加了@ResponseBody，方法上的就可以省略了
//    public String doHandleArithmeticException(ArithmeticException e){
//        //....记录日志.....
//        return "ArithmticController's exception msg is "+e.getMessage();
//    }//此异常处理方法，可以处理这个方法所在类的所有算术异常。

}
