package com.cy.pj.brand.dao;

import com.cy.pj.brand.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BrandDaoTests {
    @Autowired
    private BrandDao brandDao;
    @Test
    void testFindBrands() {
        List<Brand> list = brandDao.findBrands("A");
        for (Brand b : list) {
            System.out.println(b);
        }
    }
}
