package com.example.springboot18.view;

import lombok.Data;

@Data
public class PageView {

    private Integer pageSize;

    private Integer pageNum;

    // index = (pageNum-1)*pageSize

    public int getStartIndex() {
        return (pageNum - 1) * pageSize;
    }


}
