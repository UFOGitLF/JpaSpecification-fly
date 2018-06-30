package com.example.jpamicroservice.service.impl;

import com.example.jpamicroservice.domain.Person;
import com.example.jpamicroservice.domain.Phone;
import com.example.jpamicroservice.domain.Power;
import com.example.jpamicroservice.query.QueryCondition;
import com.example.jpamicroservice.repository.PersonRepository;
import com.example.jpamicroservice.service.PersonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonRepository personRepository;

    @Override
    public Set<Person> findByCondition(QueryCondition queryCondition) {
        Specification<Person> specification = (Specification<Person>) (root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(queryCondition.getPowerName())) {
                Join<Person, Phone> personPhoneJoin = root.join("phones", JoinType.LEFT);
                Join<Phone, Power> phonePowerJoin = personPhoneJoin.join("powers", JoinType.LEFT);
                predicates.add(cb.like(phonePowerJoin.get("powerName").as(String.class), "%" + queryCondition.getPowerName() + "%"));
            }
            if (StringUtils.isNotBlank(queryCondition.getPhoneNumber())) {
                Join<Person, Phone> personPhoneJoin = root.join("phones", JoinType.LEFT);
                predicates.add(cb.equal(personPhoneJoin.get("phoneNumber").as(String.class), queryCondition.getPowerName()));
            }
            if (StringUtils.isNotBlank(queryCondition.getPersonName())) {
                predicates.add(cb.like(root.get("personName").as(String.class), "%" + queryCondition.getPersonName() + "%"));
            }
            if (null != queryCondition.getPersonAge()) {
                predicates.add(cb.equal(root.get("personAge").as(Integer.class), queryCondition.getPersonAge()));
            }
            Predicate[] p = new Predicate[predicates.size()];
            return cb.and(predicates.toArray(p));
        };
        /**
         * 探究延迟加载的问题
         */
        List<Person> personList = personRepository.findAll(specification);
        for (Person person : personList) {
            List<Phone> phoneList = person.getPhones();
            for (Phone phone : phoneList) {
                List<Power> powerList = phone.getPowers();
                for (Power power : powerList) {
                    System.out.println(power.getPowerName());
                }
            }
        }
        return new HashSet<>(personList);
    }
}
