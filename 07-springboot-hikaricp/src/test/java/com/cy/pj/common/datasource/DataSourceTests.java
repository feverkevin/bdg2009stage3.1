package com.cy.pj.common.datasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

/**在单元测试类的单元测试方法中，从数据库连接池获取一个链接，并输出链接信息
 * 1)如何获取连接池？(从哪里获取)
 * 1.1)Java中所有的连接池必须实现一个规范(javax.sql.DataSource)
 * 1.2)在程序中需要提供DataSource接口的具体实现?(添加连接池依赖)
 * 2)拿到连接池以后如何注入给我们的测试类
 * */
@SpringBootTest
public class DataSourceTests {
      //DataSource 是什么？Java官方定义的一个连接池规范
      //运行时dataSource指向的对象类型是谁？(HikariDataSource)，你怎么知道的?断点分析
      @Autowired
      private DataSource dataSource;

      @Test
      void testGetConnection() throws SQLException {
          //System.out.println(dataSource.getClass().getName());//获取dataSource变量指向的实际对象类型
          //这里的链接是从哪里获取的，你怎么知道？从连接池获取，断点分析
          System.out.println(dataSource.getConnection());
      }


}
