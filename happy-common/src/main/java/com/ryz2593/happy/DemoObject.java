package com.ryz2593.happy;

import lombok.Data;

/**
 * @author ryz2593
 * @date 2019/9/9
 * @desc
 */
@Data
public class DemoObject {
    private Integer id;
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
