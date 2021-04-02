package com.cy.pj.goods.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class GoodsDaoTests {
    @Autowired
    private GoodsDao goodsDao;//DefaultGoodsDao

    @Test
    void testFindGoods(){
        long t1=System.currentTimeMillis();
        List<Map<String,Object>> list= goodsDao.findGoods();
        long t2=System.currentTimeMillis();
        System.out.println("first query:"+(t2-t1));

        list= goodsDao.findGoods();
        long t3=System.currentTimeMillis();
        System.out.println("second query:"+(t3-t2));

        for(Map<String,Object> map:list){
            System.out.println(map);
        }
       //while(true){}
    }
}
