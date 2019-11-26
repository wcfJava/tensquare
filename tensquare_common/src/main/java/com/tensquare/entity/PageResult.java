package com.tensquare.entity;


import java.util.List;

/**
 * @ClassName: PageResult
 * @Description: 分页返回结果
 * @Author: wangcunfu
 * @Date: 2019/11/25 21:28
 * @Version: v1.0 文件初始创建
 */
public class PageResult<T> {
    /** 总条数 */
    private Long total;
    /** ??? */
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
