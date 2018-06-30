package com.example.jpamicroservice.controller;

import com.example.jpamicroservice.query.QueryCondition;
import com.example.jpamicroservice.service.PersonService;
import com.example.jpamicroservice.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("person")
public class PersonController {
    @Resource
    private PersonService personService;

    @GetMapping("list")
    public ResultVO personList(QueryCondition queryCondition) {
        return ResultVO.success(personService.findByCondition(queryCondition));
    }
}
