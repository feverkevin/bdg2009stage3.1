package com.cy.pj.goods.dao;

import java.util.List;
import java.util.Map;

public interface GoodsDao {
    /**
     * 查询商品表中的所有商品信息,表中每行记录映射为内存中的一个map对象,
     * map对象中key为select列表中的字段名,map中的value为表中字段名对应的值.
     * 多行记录可能有多个map,然后我们在内存中就需要将多个map存储到list集合.
     * @return
     */
     List<Map<String,Object>> findGoods();
}
