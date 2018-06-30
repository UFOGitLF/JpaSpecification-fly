package com.example.jpamicroservice.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> ResultVO success(T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(200);
        resultVO.setMsg("SUCCESS");
        resultVO.setData(data);
        return resultVO;
    }
}
