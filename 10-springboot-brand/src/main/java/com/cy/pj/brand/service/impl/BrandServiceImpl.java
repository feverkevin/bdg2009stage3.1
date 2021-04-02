package com.cy.pj.brand.service.impl;

import com.cy.pj.brand.dao.BrandDao;
import com.cy.pj.brand.pojo.Brand;
import com.cy.pj.brand.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j //当使用lombok中的这个注解时，系统底层在编译类时，会自动在字节码文件中添加一个log对象
@Service
public class BrandServiceImpl implements BrandService {
      //这句话不用写了，因为我们的类上添加了一个@Slf4j
     //private static final Logger log= LoggerFactory.getLogger(BrandServiceImpl.class);
    @Autowired
    private BrandDao brandDao;

    @Override
    public Brand findById(Integer id) {
        return brandDao.findById(id);
    }

    @Override
    public int updateBrand(Brand brand) {
        //...........
        return brandDao.updateBrand(brand);
    }
   @Override
    public int saveBrand(Brand brand) {
        //...........
        return brandDao.insertBrand(brand);
    }

    /**
     * 基于id执行品牌删除业务
     * @param id (品牌id-参数类型尽量使用对象类型，其长度尽量与表中设计一致)
     * @return
     * 思考：将来这个删除业务中除了执行数据删除操作外，你还可能会做什么？
     * 1)权限控制?(你有删除权限才可以删除这个记录)
     * 2)事务控制？
     * 3)日志记录
     * 4).........
     */
    @Override
    public int deleteById(Integer id) {
        //...
        int rows=brandDao.deleteById(id);
        //...
        return rows;
    }

    @Override
    public List<Brand> findBrands(String name) {
        log.info("start:{}",System.currentTimeMillis());
        List<Brand> list=brandDao.findBrands(name);
        log.info("end:{}",System.currentTimeMillis());
        return list;
    }
}
