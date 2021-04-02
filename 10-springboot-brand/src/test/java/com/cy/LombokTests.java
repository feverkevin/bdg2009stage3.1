package com.cy;

import com.cy.pj.brand.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LombokTests {

    @Test
    void testLombok(){
        Brand b1=new Brand();
        b1.setId(100);
        System.out.println(b1.getId());
        System.out.println(b1);//默认会调用对象的toString方法
        Brand b2=new Brand();
        b2.setId(100);
        System.out.println(b1.equals(b2));

    }
}
