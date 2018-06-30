package com.example.jpamicroservice.service;

import com.example.jpamicroservice.domain.Person;
import com.example.jpamicroservice.query.QueryCondition;

import java.util.Set;

public interface PersonService {
    Set<Person> findByCondition(QueryCondition queryCondition);
}
