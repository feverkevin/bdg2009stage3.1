package com.cy.pj.goods.dao;

import com.cy.pj.goods.pojo.Goods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsDaoTests {

    @Autowired
    //@Qualifier("goodsDaoImpl")
    private GoodsDao goodsDao;
    //系统底层默认产生的GoodsDao的实现类，它的bean的名字为接口名，首字母小写。

    @Test
    void testDeleteObjects(){
        int rows=goodsDao.deleteObjects();
        System.out.println("delete.rows="+rows);
    }

    @Test
    void testDeleteById(){
         int rows=goodsDao.deleteById(4);
         //断言测试法(期望值和实际值相同时测试通过，否则测试失败)
         Assertions.assertEquals(1, rows);
         //other tests
         System.out.println("delete.rows="+rows);
    }

    @Test
    void testFindGoods(){
        List<Goods> list= goodsDao.findGoods();
        System.out.println(list.size());
        for(Goods g:list){
            System.out.println(g);
        }

    }
}
