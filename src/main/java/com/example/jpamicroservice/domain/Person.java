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
