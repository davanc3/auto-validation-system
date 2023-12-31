package com.avs.autoValidationSystem.model.dto.impl;

import com.avs.autoValidationSystem.model.dto.Dto;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

//todo: добавить валидацию
@ToString
public class ErrorDto implements Dto {
    private final HttpStatus httpStatus;
    private String msg = "Произошла ошибка сервера";

    public ErrorDto(HttpStatus httpStatus, String msg) {
        this.httpStatus = httpStatus;
        this.msg = msg;
    }

    public ErrorDto(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMsg() {
        return msg;
    }
}
