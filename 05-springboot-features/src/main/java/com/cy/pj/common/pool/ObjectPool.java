package com.cy.pj.common.pool;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 创建一个对象池类型,然后将此类型的对象交给spring管理.
 * @Component注解描述的对象可以交给spring去管理,表示这个对象是一个一般组件.
 * 系统底层会通过反射技术创建Bean实例,并为Bean起一个名字.
 *
 * 反射?Java中的一种高级特性,这组特性会借助一组API,获取运行时的类及其的成员,并进行操作.
 * 反射最大优势?不能预知未来,但可以驾驭未来.
 * Java中应用反射技术的起点是什么? 获取Class对象(字节码对象)
 */
@Component
@Scope("prototype")//prototype 为多实例作用域,每次从spring框架请求类的实例都会创建新的
//@Scope("singleton")//此注解用于设置bean对象的作用域,默认为singleton(单例),相同名字的bean实例在内存只能有一份
//@Lazy//描述对象类型时表示延迟对象的创建,何时需要何时创建.尤其是一些大对象,短时间又不会用到我们可以采用这样策略.
//@Component("objPool")//描述bean的同时,给Bean起给名字.
public class ObjectPool {//默认bean对象的名字为类名,然后首字母小写,例如objectPool
    //byte[] array=new byte[1024*1024*1024];
    public ObjectPool(){
        System.out.println("ObjectPool()");
    }
    //生命周期方法演示:(并不是每个类中都要写这样的方法-一般在池对象的设计中都会有这样的方法)
    @PostConstruct //此注解描述的方法为对象生命周期初始化方法,此方法会在构造方法之后执行
    public void init(){
        System.out.println("init()");
    }
    @PreDestroy //此注解描述的方法为对象生命周期销毁方法,此方法会在对象销毁之前执行
    public void destroy(){
        System.out.println("destroy()");
    }

}//此类的配置在被加载到内存时,会将类的配置信息存储到Map<String,BeanDefinition>容器中
//早期创建类的实例:new ObjectPool(),new Xxxx()
//spring中为什么会使用反射创建对象,而不是直接new 对象类型的方式呢?

