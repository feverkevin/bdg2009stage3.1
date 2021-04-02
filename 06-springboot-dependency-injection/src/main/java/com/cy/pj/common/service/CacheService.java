package com.cy.pj.common.service;

import com.cy.pj.common.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
   @Autowired
   @Qualifier("softCache")
   private Cache cache;
   //当类中有多个构造函数,但是构造函数又没有使用@Autowired注解描述,则优先调用无参数构造函数构建对象
   //public CacheService(){}

   //通过构造函数实现值的注入
//   @Autowired //可以描述构造方法,但这个注解可以省略(只有这一个构造函数时)
//   public CacheService(@Qualifier("softCache")Cache cache){//@Qualifier可以描述参数
//       this.cache=cache;
//   }

    //通过set方法为属性赋值
//    @Autowired
//    public void setCache(@Qualifier("softCache")Cache cache) {
//        System.out.println("==setCache()===");
//        this.cache = cache;
//    }

     public Cache getCache() {
        return cache;
     }
}
