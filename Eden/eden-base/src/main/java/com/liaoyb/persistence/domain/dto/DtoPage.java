package com.liaoyb.persistence.domain.dto;

import java.util.List;

/**
 * 到页面的分页数据
 *
 * @author liao
 * @create 2016-01-14-10:33
 **/
public class DtoPage {
    private Long total;
    private Long pageSize;
    //当前页
    private Long pageNumber;
    private List rows;

    public DtoPage() {
    }

    public DtoPage(Long total, Long pageSize, Long pageNumber, List rows) {
        this.total = total;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
