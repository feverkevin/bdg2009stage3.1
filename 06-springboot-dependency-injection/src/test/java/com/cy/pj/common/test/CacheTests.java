package com.cy.pj.common.test;

import com.cy.pj.common.cache.Cache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTests {
    //思考:当使用@Autowired注解描述属性时,spring底层按什么规则为属性赋值?(DI)
    //规则如下:
    //1)首先基于属性类型从spring容器中查询其对象,假如只有一个则直接注入.
    //2)假如属性类型对应的对象有多个,则基于属性名进行查找,假如有名字相同的则直接注入,没有则注入失败
    //假如我们希望为属性注入指定名字的bean对象,该如何实现?
    //借助 @Qualifier注解描述属性并指定要注入的bean的名字.(这个注解必须配合Autowired注解使用)
    //底层通过什么方式为属性赋值(DI)? 反射技术
    @Autowired
    @Qualifier("softCache") //DL (Dependency Lookup)-->DI(Dependency Injection)
    private Cache cache;//引入包下的类alt+enter

    @Test
    void testCache(){
        System.out.println(cache);
    }

}
