package com.bootcamp.pragma.stockmicroservice.domain.model;

import java.util.List;

public class ContentPage<T> {
    private int totalPage;
    private long totalElements;
    private int pageNumber;
    private int pageSize;
    private boolean first;
    private boolean last;
    private List<T> content;

    public ContentPage(int totalPage, long totalElements, int pageNumber, int pageSize, boolean first, boolean last, List<T> content) {
        this.totalPage = totalPage;
        this.totalElements = totalElements;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.first = first;
        this.last = last;
        this.content = content;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
