package com.cy.pj.common.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 响应标准对象设计(用于封装服务端响应到客户端的数据)
 *
 * FAQ?
 * 1.何为序列化，反序列化?(I/O)-类似生活中拼图
 * 1)序列化:将对象转换为字节的过程？
 * 2)反序列化：将字节转换为对象的过程？
 * 2.序列化的应用场景？
 * 1)将内存中的对象直接存储到文件
 * 2)将内存中的对象通过网络进行传输
 * 3).......
 * 3.序列化实现？
 * 1)ObjectOutputStream (序列化)-->writeObject
 * 2)ObjectInputStream (反序列化)-->readObject
 */
@Data
@NoArgsConstructor
public class JsonResult implements Serializable {
    /**序列化，反序列化时的唯一标识
     * 当类的结构发生变化时，只要serialVersionUID不变，JVM底层都认为它是同一个类。
     */
    private static final long serialVersionUID = -4971076199594828397L;//ResultResult
    private Integer state=1;
    private String message="ok";
    private Object data;
    public JsonResult(String message){
        this.message=message;
    }
    public JsonResult(Object data){
        this.data=data;
    }
    public JsonResult(Throwable e){
        this.state=0;
        this.message=e.getMessage();
    }
}
