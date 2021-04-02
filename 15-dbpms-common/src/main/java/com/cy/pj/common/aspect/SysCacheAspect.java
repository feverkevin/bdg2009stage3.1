package com.cy.pj.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**缓存切面*/
//@Order(1)
@Aspect
@Component
public class SysCacheAspect {
    //假设这是我们的cache对象(将来cache对象可能借助第三方cache产品)
    private Map<String,Object> cache=new ConcurrentHashMap<>();//并发安全

    @Pointcut("@annotation(com.cy.pj.common.annotation.RequiredCache)")
    public void doCache(){}

    @Pointcut("@annotation(com.cy.pj.common.annotation.ClearCache)")
    public void doClearCache(){}

    @AfterReturning("doClearCache()")
    public void doAfterReturing(){
        cache.clear();
    }

    @Around("doCache()")
    public Object doAround(ProceedingJoinPoint joinPoint)throws  Throwable{
        System.out.println("Get Data from cache");
        Object result=cache.get("deptKey");//这里的key先用一个固定值，将来需要结合业务进行设计
        if(result!=null)return result;
        //从数据库去查询数据
        result=joinPoint.proceed();//service-->dao-->db
        System.out.println("Put Data to Cache");
        cache.put("deptKey", result);
        return result;
    }

}
