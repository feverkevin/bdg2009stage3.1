package com.cy.pj.goods.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据访问层对象的具体实现,在实现类中借助JDBC借助直接访问数据库,
 * @Repository 是spring框架中定义一个描述数据层bean对象的注解
 */
@Repository //是一个特殊的Component对象
public class DefaultGoodsDao  implements  GoodsDao{
    @Autowired
    private DataSource dataSource;

    //初始化一个日志对象(所有类都在org.slf4j包中)
    //在哪个类创建日志对象，我们的getLogger方法内部的对象就为哪个类的字节码对象
    private static final Logger log=
            LoggerFactory.getLogger(DefaultGoodsDao.class);

    //行映射
    Map<String,Object> rowMap(ResultSetMetaData rsmd,ResultSet rs)throws SQLException{
          Map<String,Object> map=new HashMap<>();
          for(int i=1;i<=rsmd.getColumnCount();i++){//循环取出所有字段的值
              map.put(rsmd.getColumnName(i),rs.getObject(rsmd.getColumnName(i)));
          }
          return map;
    }
    //释放资源
    public void close(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null)try{rs.close();}catch(SQLException e1){}
        if(stmt!=null)try{stmt.close();}catch(SQLException e1){}
        if(conn!=null)try{conn.close();}catch(SQLException e1){}
    }
    @Override
    public List<Map<String, Object>> findGoods() {
        Connection conn=null;
        Statement stmt=null;
        String sql="select * from tb_goods";
        ResultSet rs=null;
        try {
            //1.获取连接
            conn = dataSource.getConnection();
            //2.创建statement
            stmt = conn.createStatement();
            //3.发送sql
            rs = stmt.executeQuery(sql);
            //4.处理结果
            List<Map<String, Object>> list = new ArrayList<>();
            ResultSetMetaData rsmd=rs.getMetaData();//获取结果集中的元数据(描述数据的数据)?
            while (rs.next()) {//循环一次取一行,这个过程通常称之为行映射
//                Map<String, Object> map = new HashMap<>();
//                map.put("id", rs.getInt("id"));
//                map.put("name", rs.getString("name"));
//                map.put("remark", rs.getString("remark"));
//                map.put("createdTime", rs.getTimestamp("createdTime"));
//                list.add(map);、
                //映射方案2
                 list.add(rowMap(rsmd,rs));
            }
            return list;
        }catch (SQLException e){
            //e.printStackTrace();
            //记录日志(一般异常日志借助log.error方法进行记录)
            log.error("查询异常,{}",e.getMessage());//{}表示占位符
            //return null;
            throw new RuntimeException("数据查询失败"+e.getMessage());
        }finally{
            //5.释放资源
            close(rs,stmt,conn);
        }
    }
}
/**
 * 对于如上查询商品数据的过程有什么优缺点？
 *  优点：
 *  1)代码简单(就是一些流水代码-步骤固定)
 *  2)使用了连接池，优化了建立连接的过程，从池中获取连接，提高了数据访问性能。
 *  3)使用了map做映射，简化了pojo对象定义
 *
 *  缺点：
 *  1)可重用性比较差(例如资源释放代码，完全可以封装)
 *  2)行映射不够灵活，过于僵硬。
 *  3)异常的处理不能简单打印一下，然后返回一个null就可以了,通常要做日志记录。
 *  4)Map封装数据时，值的类型不可控(建议后续修改为pojo对象)
 *  5)对共性模板应该进行封装，特性代码进行提取
 */
