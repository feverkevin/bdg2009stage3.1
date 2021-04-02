package com.cy.pj.arithmetic.controller;

import com.cy.pj.common.pojo.ResponseResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

//@Controller
//@ResponseBody
@Validated
@RestController
public class ArithmeticController {
    @RequestMapping("/doCompute/{n1}/{n2}")
    public ResponseResult doCompute(@PathVariable Integer n1,

                                    //@Pattern(regexp="^[1-9]*$",message = "必须是1到9之间的数字")
                                    @Min(value=1,message = "除数必须大于等于1")
                                    @PathVariable  String n2){
        //if(n2==0)throw new IllegalArgumentException("除数不能为0");
        Integer result=n1/Integer.valueOf(n2);
        return new ResponseResult("result is "+result);//正常结果数据
    }
}
