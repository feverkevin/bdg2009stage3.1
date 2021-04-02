package com.cy;

import com.cy.pj.module.pojo.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootTest
public class ReflectTests {

    @Test
    void testGetMethods() throws InvocationTargetException, IllegalAccessException {
        //反射的起点:Class类型的对象
        //Class<?> clz=ResponseResult.class;
        ResponseResult result=new ResponseResult();
        result.setCode(200);
        result.setMessage("ok");
        Class<?> clz=result.getClass();
        //获取类中的所有方法
        Method[] ms=clz.getDeclaredMethods();
        for(Method m:ms){
            if(m.getName().startsWith("get")){//获取所有以get开头的方法
                //System.out.println(m.getName());
                String key=m.getName().substring(3);
                key=key.substring(0,1).toLowerCase()+key.substring(1);
                Object value=m.invoke(result);//反射执行result对象的get方法
                System.out.println(key+":"+value);
            }
        }
    }
}
