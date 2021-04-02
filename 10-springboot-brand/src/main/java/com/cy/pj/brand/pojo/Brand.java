package com.cy.pj.brand.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode //底层重写hashCode和equals方法，但默认规则不符合要求时，我们还需要自己重写
@Data
//@RequiredArgsConstructor //为使用 @NonNull描述的属性生成构造函数，也会添加无参构造
@NoArgsConstructor //在类中添加无参构造函数
//@AllArgsConstructor //在类中添加全参构造函数
public class Brand {//品牌模块的POJO对象，基于此对象封装品牌信息
    //@NonNull
    private Integer id;
    //@NonNull
    private String name;
    private String remark;
    private Date createdTime;
    public Brand(Integer id){
        this.id=id;
    }
}//lombok是调用了底层API，在类进行编译时为我们的类(字节码文件)生成相关方法
//?请问是注解为类添加方法吗？不是，注解仅仅是描述，告诉底层要做什么
