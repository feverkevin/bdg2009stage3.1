package com.cy.pj.goods.service;

import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 此对象负责商品模块的业务逻辑处理
 * 1)通过数据层对象访问业务数据
 * 2)通过日志对象记录日志
 * 3)通过第三方框架进行权限控制
 * 4)还可以做Cache。。。。
 * 5)..................
 */
@Service
public class GoodsServiceImpl implements  GoodsService{
    private static final Logger log=LoggerFactory.getLogger(GoodsServiceImpl.class);
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public int deleteObjects(Integer... ids) {
        int count=0;
//        for(int i=0;i<ids.length;i++){
//            int rows=goodsDao.deleteById(ids[i]);
//            count+=rows;
//        }
        count=goodsDao.deleteObjects(ids);//批量删除
        return count;
    }

    @Override
    public List<Goods> findGoods() {
        long t1=System.currentTimeMillis();
        log.info("start {}",t1);
        List<Goods> list=goodsDao.findGoods();
        long t2=System.currentTimeMillis();
        log.info("end {}",t2);
        log.info("execute time {}",t2-t1);
        return list;
    }

    @Override
    public int deleteById(Integer id) {
        if(id==null||id<1)
            throw new IllegalArgumentException("传入的ID值不合法");//继承了RuntimeException
        long t1=System.currentTimeMillis();
        log.info("start {}",t1);
        int rows=goodsDao.deleteById(id);
        long t2=System.currentTimeMillis();
        log.info("end {}",t2);
        log.info("execute time {}",t2-t1);
        return rows;
    }
}
