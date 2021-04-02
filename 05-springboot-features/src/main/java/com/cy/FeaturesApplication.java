package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//检测类是否被加载?(通过JVM参数:-XX:+TraceClassLoading)
@SpringBootApplication
public class FeaturesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeaturesApplication.class, args);
	}

}
