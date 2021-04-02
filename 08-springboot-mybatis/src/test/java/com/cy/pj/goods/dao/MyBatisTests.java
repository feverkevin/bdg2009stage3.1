package com.cy.pj.goods.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

@SpringBootTest
public class MyBatisTests {
    @Autowired
    private SqlSession sqlSession;//此对象具体类型是什么?SqlSessionTemplate,由谁创建的？
    @Test
    void testGetConnection(){
        Connection conn=sqlSession.getConnection();//这里的链接从哪里来？
        System.out.println("conn="+conn);
    }
    //请问mybatis中实现与数据库会话的对象是谁？SqlSession
    //请问mybatis中sqlSession对象的创建由谁负责？SqlSessionFactory
    //SqlSessionFactory工厂谁帮我们创建？(sqlSessionFactoryBean-springboot底层已经配置好了)
}
