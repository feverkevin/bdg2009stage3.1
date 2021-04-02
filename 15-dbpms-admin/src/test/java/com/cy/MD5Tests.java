package com.cy;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@SpringBootTest
public class MD5Tests {

    @Test
    void testMd5BySpring(){
        String password="123456";
        String hashedPassword=DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println("hashdPassword="+hashedPassword);//e10adc3949ba59abbe56e057f20f883e
        //String salt=UUID.randomUUID().toString();
        String salt="3c9cceda-f79e-44e3-8f7b-640995065ad4";
        System.out.println("salt="+salt);//3c9cceda-f79e-44e3-8f7b-640995065ad4
        hashedPassword=DigestUtils.md5DigestAsHex((password+salt).getBytes());
        System.out.println("hashdPassword="+hashedPassword);//9caf7ebab94d02f4ca77eb22f8f39f35
    }
    @Test
    void testMd5ByShiro(){
        String password="123456";
        //借助Java中的UUID类产生一个随机字符串，将此字符串作为一个加密盐
        String salt= UUID.randomUUID().toString();
        System.out.println("salt="+salt);//377a8811-2377-4ac6-97b5-9da656ca7923
        //对密码进行加密(借助shiro框架中的API实现)
        SimpleHash simpleHash=
                new SimpleHash("MD5", password,salt,1);
        String hashedPassword=simpleHash.toHex();//将加密结果转换为16进制
        System.out.println("hashedPassword="+hashedPassword);
    }
    //........................
}
