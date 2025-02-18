package com.czk.tliasmanagementsystem.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

public class PageBean {

    private Long total;
    private List rows;

    public PageBean() {
    }

    public PageBean(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
