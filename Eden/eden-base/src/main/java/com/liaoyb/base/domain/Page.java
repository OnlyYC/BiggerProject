package com.liaoyb.base.domain;

import com.alibaba.fastjson.JSON;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * dao层使用的分页
 *
 * @author liao
 * @create 2016-01-07-10:54
 **/
public class Page<T> implements Serializable {
    public static final String ASC = "asc";
    public static final String DESC = "desc";
    public static int DEFAULT_PAGE_SIZE = 10;
    protected int pageNumber;
    protected int pageSize;
    protected List<T> result;
    protected long totalCount;
    protected String orderBy;//实例： updatedate desc, name asc


    public Page(int pageSize) {
        this.pageNumber = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.result = Collections.emptyList();
        this.totalCount = -1L;
        this.orderBy = null;
        this.setPageSize(pageSize);
    }

    public Page(int pageSize, boolean autoCount) {
        this.pageNumber = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.result = Collections.emptyList();
        this.totalCount = -1L;
        this.orderBy = null;
        this.setPageSize(pageSize);
    }

    public Page() {
        this(DEFAULT_PAGE_SIZE);
    }

    public Page(long totalSize, int pageSize, List<T> data) {
        this.pageNumber = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.result = Collections.emptyList();
        this.totalCount = -1L;
        this.orderBy = null;
        this.pageSize = pageSize;
        this.totalCount = totalSize;
        this.result = data;
    }


    public long getTotalPageCount() {
        Assert.isTrue(this.pageSize > 0);
        return this.totalCount % (long)this.pageSize == 0L?this.totalCount / (long)this.pageSize:this.totalCount / (long)this.pageSize + 1L;
    }

    public boolean isOrderBySetted() {
        return !StringUtils.isEmpty(this.orderBy);
    }

    public int getFirstOfPage() {
        return (this.pageNumber - 1) * this.pageSize + 1;
    }

    public int getLastOfPage() {
        return this.pageNumber * this.pageSize;
    }

    public static int getDEFAULT_PAGE_SIZE() {
        return DEFAULT_PAGE_SIZE;
    }

    public static void setDEFAULT_PAGE_SIZE(int dEFAULTPAGESIZE) {
        DEFAULT_PAGE_SIZE = dEFAULTPAGESIZE;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getResult() {
        return this.result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }




    public String getOrderBy() {
        return this.orderBy;
    }



    //

    /**
     * 设置排序的条件,使用升序
     * @param param 以此为根据
     */
    public void setOrderByAsc(String param){
        setOrderByStr(param,ASC);
    }
    /**
     * 设置排序的条件,使用降序
     * @param param 以此为根据
     */
    public void setOrderByDesc(String param){
        setOrderByStr(param,DESC);
    }

    private  void setOrderByStr(String param, String str){
        if(this.orderBy==null){
            this.orderBy="";
        }
        if(orderBy.length()==0){
            this.orderBy=" "+param+" "+str+" ";
        }else{
            this.orderBy+=(","+param+" "+str+" ");
        }
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getJartJsonResult() {
        return "{total:" + this.getTotalCount() + ",rows:" + JSON.toJSONString(this.getResult()) + "}";
    }
}