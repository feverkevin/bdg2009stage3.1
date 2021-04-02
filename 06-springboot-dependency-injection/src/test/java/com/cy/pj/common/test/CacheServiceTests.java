package com.cy.pj.common.test;

import com.cy.pj.common.service.CacheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheServiceTests {
    @Autowired
    private CacheService cacheService;

    @Test
    void testGetCache(){
        System.out.println(cacheService.getCache());
    }
}
