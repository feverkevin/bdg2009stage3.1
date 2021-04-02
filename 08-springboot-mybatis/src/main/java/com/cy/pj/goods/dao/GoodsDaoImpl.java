package com.cy.pj.goods.dao;

import com.cy.pj.goods.pojo.Goods;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GoodsDaoImpl implements  GoodsDao{

    @Autowired
    private  SqlSession sqlSession;//SqlSessionTemplate (线程安全)-->DefaultSqlSession
    //@Autowired
//    public GoodsDaoImpl(SqlSession sqlSession){
//        this.sqlSession=sqlSession;
//    }
    @Override
    public List<Goods> findGoods() {//在此方法内部使用sqlsession实现与数据库会话
        System.out.println("==findGoods()==");
        String statement="com.cy.pj.goods.dao.GoodsDao.findGoods";//namespace+id
        return sqlSession.selectList(statement);
    }

    @Override
    public int deleteById(Integer id) {
        String statement="com.cy.pj.goods.dao.GoodsDao.deleteById";
        return sqlSession.delete(statement, id);
    }

    @Override
    public int deleteObjects(Integer... ids) {
        String statement="com.cy.pj.goods.dao.GoodsDao.deleteObjects";
        Map<String,Object> map=new HashMap<>();
        map.put("ids", ids);
        //return sqlSession.delete(statement, ids);//不允许直接这样传值
        //一般有多个参数或者是可变参数时，这个参数要封装到map,然后再进行传递
        //map中的key一般为映射文件的sql中需要的参数
        return sqlSession.delete(statement,map);
    }
}
