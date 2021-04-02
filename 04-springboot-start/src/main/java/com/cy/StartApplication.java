package com.cy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 在springboot工程中只能有一个类是启动类,这个类需要:
 * 1)使用@SpringBootApplication注解进行描述
 * 2)此类中会有一个main方法,在main方法中初始化springboot默认配置
 * FAQ?请问此类启动时会做做什么?
 * 1)通过线程(Thread)调用IO从磁盘查找对应的类并将其读到内存(类加载)--Class Loading
 * 2)对读到内存中类进行分析,哪些是交给spring管理的,由spring管理的这些类哪些是配置类.
 * 3)对spring管理的类,底层要进行解析,将这些类的信息封装到指定对象(Map<String,BeanDefinition>)
 * 4)Spring框架可以基于Bean的配置,借助工厂构建对象,借助Map存储对象(实例-Bean对象),管理对象
 * 5)我们需要对象时,可以直接从spring容器(IOC)中去取.
 */
@SpringBootApplication
public class StartApplication {//StartApplication.class
	public static void main(String[] args) {//main方法运行在什么线程(main线程-主线程)
		SpringApplication.run(StartApplication.class, args);//固定写法
	}
}
