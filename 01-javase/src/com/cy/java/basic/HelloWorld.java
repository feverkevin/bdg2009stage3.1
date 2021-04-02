package com.cy.java.basic;
//检查类加载可以借助JVM参数：-XX:+TraceClassLoading
public class HelloWorld {//HelloWorld.class
    public static void main(String[] args) {//args 用于接收运行时出入的参数
        System.out.println("HelloWorld");//sout
        System.out.println(args[0]);//假如运行时没有传入参数会出现数组下标越界异常
        System.out.println(args[1]);
    }
}
