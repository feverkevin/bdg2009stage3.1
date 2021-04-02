package com.cy.pj.common.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
/**用于封装分析信息的pojo对象*/
public class PageObject<T> implements Serializable {
    private static final long serialVersionUID = -3130527491950235344L;
    /**总记录数*/
    private Integer rowCount;
    /**当前页记录*/
    private List<T> records;
    /**总页数*/
    private Integer pageCount;
    /**页面大小-每页最多显示的记录数*/
    private Integer pageSize;
    /**当前页码值*/
    private Integer pageCurrent;
    //......


    public PageObject(Integer rowCount, List<T> records, Integer pageSize, Integer pageCurrent) {
        this.rowCount = rowCount;
        this.records = records;
        this.pageSize = pageSize;
        this.pageCurrent = pageCurrent;
        this.pageCount=rowCount/pageSize;
        if(rowCount%pageSize!=0)this.pageCount++;
    }
}
