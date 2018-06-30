package com.example.jpamicroservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String personId;
    private String phoneNumber;
    private String phoneCategory;

    @JoinColumn(name = "personId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonIgnore
    private Person person;
    /**
     * 一部手机可以有多个充电器
     */
    @OneToMany(mappedBy = "phone", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Power> powers;
}
