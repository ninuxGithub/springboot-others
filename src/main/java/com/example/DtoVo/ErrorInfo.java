package com.example.DtoVo;

import lombok.Data;

/**
 * Created by daile on 2017/7/3.
 */
@Data
public class ErrorInfo<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;
}
