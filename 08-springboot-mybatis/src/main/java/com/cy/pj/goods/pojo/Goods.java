package com.cy.pj.goods.pojo;
import java.util.Date;
/**设计一个POJO对象，通过此对象封装查询到的商品信息*/
public class Goods {
    private Long id;
    private String name;
    private String remark;
    private Date createdTime;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }

    //添加set/Get方法时可以使用使用,alt+insert
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
