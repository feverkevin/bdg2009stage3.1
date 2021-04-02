package com.cy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

//	int sum(int a ,int b){
//		return a+b;
//	}
//	int sum(int a,int b,int c){
//		return a+b+c;
//	}
//	int sum(int a,int b,int c,int d){
//		return a+b+c+d;
//	}
	//可变参数为jdk1.5的新特性，用于简化参数类型相同，个数不同的一些重载方法的定义
	//可以将可变参数看成是一个特殊的数组
	int sum(int... array){//int...代表可变参数的写法
		if(array.length==0)return 0;
		int sum=0;
		for(int i=0;i<array.length;i++){
			sum+=array[i];
		}
		return sum;
	}
	@Test
	void testSum(){
		sum(10,20,30);
	}


}
