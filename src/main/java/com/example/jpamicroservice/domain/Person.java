package com.example.jpamicroservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String personName;
    private Integer personAge;

    /**
     * mappedBy属性存在于(@OneToOne,@oneToMany,@ManyToMany中，指定关系维护方)
     * 一个人可以有多部手机故使用：@OneToMany
     * ALL,级联所有实体状态转换
     * PERSIST,级联持久化操作
     * MERGE,级联合并操作(级联更新)
     * REMOVE,级联实体删除操作
     * REFRESH,级联实体刷新操作
     * DETACH;级联实体分离操作
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Phone> phones;

    /**
     * 消除数据重复问题(此方法)
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        if (((Person) obj).getId() == null || this.getId() == null) {
            return false;
        }
        return ((Person) obj).getId().equals(this.getId());
    }
}
