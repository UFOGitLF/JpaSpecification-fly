package com.example.jpamicroservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer personId;
    private String phoneNumber;
    private String phoneCategory;
    /**
     * 一部手机可以有多个充电器
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "phoneId")
    private List<Power> powers;
}
