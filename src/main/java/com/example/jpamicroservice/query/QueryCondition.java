package com.example.jpamicroservice.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QueryCondition {
    private String powerName;
    private String phoneNumber;
    private String personName;
    private Integer personAge;
    private Integer pageNo;
    private Integer pageSize;

    public QueryCondition() {
        this.pageNo = 1;
        this.pageSize = 10;
    }
}
