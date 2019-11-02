package com.liu.domain;

import java.util.List;

public class Page<T> {
    private int totalPage;
    private int totalPageCount;
    private List<T> dataList;
    private int currentPage;//当前页码
    private int rows;//每页条数

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalPage=" + totalPage +
                ", totalPageCount=" + totalPageCount +
                ", dataList=" + dataList +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
