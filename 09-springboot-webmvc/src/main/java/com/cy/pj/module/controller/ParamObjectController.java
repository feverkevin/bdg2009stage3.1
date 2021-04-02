package com.cy.pj.module.controller;

import com.cy.pj.module.pojo.RequestParameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * 通过此Controller处理请求中参数？
 * 1)将请求参数直接赋值给给方法参数中的直接量变量(8种封装类+String+Date)
 * 2)将请求参数直接赋值给pojo对象(pojo对象需要提供与请求参数对应的set方法)
 * 3)将请求参数直接赋值给map对象(key/value)
 *
 * 客户端常用传参方式？
 * 1)普通方式：url?paramName1=paramValue1&paramName2=paramValue2
 * 2)rest方式：path/{paramName}
 * 3).............
 */
@RestController
public class ParamObjectController {//Handler
       /**以直接量的方式接收请求中的参数(方法中参数名需要需请求参数名相同)
        * http://localhost/doHandleRequestParam01?name=tony
        * */
       @RequestMapping("/doHandleRequestParam01")
       public String doHandleRequestParam01(String name){
          return "request params is "+name;
       }

    /**以直接量的方式接收请求中的参数(方法中参数名需要需请求参数名相同)
     * http://localhost/doHandleRequestParam02?name=tony&startDate=2020/12/04
     *
     * @RequestParam 此注解可以描述方法参数，用于对方法参数进行相关设置，
     * 使用此注解描述参数时，默认客户端必须要给它描述的参数传一个值。
     * 不传值直接400异常。
     *
     *  @DateTimeFormat 描述日期参数，用于指定可以接收的日期格式 默认为"yyyy/MM/dd HH:mm"
     * */
      @RequestMapping("/doHandleRequestParam02")
      public String doHandleRequestParam02(String name,
                                           @DateTimeFormat(pattern = "yyyy/MM/dd")
                                           @RequestParam(required = true) Date startDate){
              return "request params name="+name+"/startDate="+startDate;
      }

    /**
     * Rest 风格的url定义
     * rest 风格：一种软件架构编码风格，这种风格中定义了url的一种格式，其语法：
     * /a/b/{c}/d/{e},其中{}内部内容为变量，例如
     * 1)a/b/100/d/200
     * 2)a/b/e/d/f
     * 假如在方法参数中想获取rest url中变量值，使用@PathVariable注解对方法参数进行描述，
     * 前提是方法参数名需要与url中的变量相同。
     * @param id
     * @return
     */
     @RequestMapping("/doHandleRequestParam03/{id}/{code}")
     public String doHandleRequestParam03(@PathVariable Integer id,
                                          @PathVariable Integer code){
        return "request params id="+id+"/code="+code;
     }
     //=================基于pojo对象接收请求参数=================================

    /**
     * 当请求参数比较多时，控制层方法中如何接收请求参数？
     * 通过方法中的pojo对象来接收请求中参数数据，但这里有一个前提条件：
     * pojo对象的set方法需要与请求参数的参数名匹配
     * @param pojo
     * @return
     * 访问方式，例如
     * http://localhost/doHandleRequestParam04?name=tony&startDate=2020-12-04
     */
    @RequestMapping("/doHandleRequestParam04")
    public String doHandleRequestParam04(RequestParameter pojo){
         return "request params "+pojo.toString();
    }

    /***
     * rest 风格url传值
     * @param pojo
     * @return
     * http://localhost/doHandleRequestParam05/Jason/2020-12-09
     * 说明：当使用pojo对象接收rest风格url中变量的值时，无需使用
     * @PathVariable 对控制层pojo类型参数进行描述
     */
    @RequestMapping("/doHandleRequestParam05/{name}/{startDate}")
    public String doHandleRequestParam05(RequestParameter pojo){
        return "request params "+pojo.toString();
    }

    //=============基于map接收请求中的参数数据==========================

    /**
     * 假如客户端请求参数比较多，但又不想定义pojo接收请求参数，那该如何实现？
     * 借助map可以，但是一般不推荐(map一般无法对请求参数进行限制)。
     * @param map
     * @return
     * 假如使用map接收请求参数，需要在方法参数前使用@RequestParam注解进行描述
     *
     * 访问：http://localhost/doHandleRequestParam06?name=AA&startDate=2020/12/45
     */
    @RequestMapping("/doHandleRequestParam06")
    public String doHandleRequestParam06(@RequestParam Map<String,Object> map){
        return "request params "+map.toString();
    }

    /**
     * Rest风格url参数
     * @param map
     * @return
     * 说明：当使用map接收rest风格中的数据时，需要使用@PathVariable注解对map参数
     * 进行描述。不能使用@RequestParam注解，因为此注解描述的参数只能接收普通url中
     * “？”符号后面定义的参数值
     */
    @RequestMapping("/doHandleRequestParam07/{name}/{startDate}")
    public String doHandleRequestParam07(@PathVariable  Map<String,Object> map){
        return "request params "+map.toString();
    }

}
