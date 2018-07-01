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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId")
    private List<Phone> phones;
}
