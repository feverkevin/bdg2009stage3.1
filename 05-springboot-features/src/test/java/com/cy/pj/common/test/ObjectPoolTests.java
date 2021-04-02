package com.cy.pj.common.test;

import com.cy.pj.common.pool.ObjectPool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectPoolTests {

    @Autowired
    private ObjectPool objectPool01;

    @Autowired
    private ObjectPool objectPool02;

    @Test
    void testObjectPool(){
        //@Scope("singleton")
        System.out.println(objectPool01==objectPool02);//true
    }
}
