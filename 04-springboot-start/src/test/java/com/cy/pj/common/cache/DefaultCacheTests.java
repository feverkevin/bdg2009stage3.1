package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**使用@SpringBootTest注解描述的类
 * 为springboot工程中的单元测试类,而且这个单元测试类会交给spring管理*/
@SpringBootTest
public class DefaultCacheTests {
    /**@Autowire注解描述的属性由spring为其赋值(DI)*/
    @Autowired
    private DefaultCache defaultCache;//假如没有这样的bean会报NoSuchBeanDefinitionException

    @Test
     void testDefaultCache(){
        System.out.println(defaultCache);//com.cy.pj.common.cache.DefaultCache@30272916
        //当输出的defaultCache属性的值为null,可能的原因是什么?
        //1)属性赋值(自己没有赋值,也没有让spring赋值)
        //2)属性在的类没有使用@SpringBootTest注解描述
        //3)@Test类引入错误(包不正确-org.junit.jupiter.api.Test)
    }
}
