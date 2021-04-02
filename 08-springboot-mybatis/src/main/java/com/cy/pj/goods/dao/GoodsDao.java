package com.cy.pj.goods.dao;

import com.cy.pj.goods.pojo.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Mapper 此注解描述的接口为数据逻辑层接口，
 * 此接口的实现类会由mybatis创建，这个实现类
 * 对象会交给spring管理
 */
@Mapper
public interface GoodsDao {//商品模块的数据访问对象
     List<Goods> findGoods();

     @Delete("delete from tb_goods where id=#{id}")
     int deleteById(Integer id);

     //假如采用下面的方式定义删除方法，该如何实现？
     int deleteObjects(@Param("ids")Integer... ids);//...为jdk1.5中的可变参数写法，可以理解为特殊数组
}//这个接口的实现类是在运行时产生的(没有对应的源码)

