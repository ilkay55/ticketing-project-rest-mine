package com.cydeo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(String message, Object data, HttpStatus httpStatus) { //dahafazla http response almak için HttpStatus parametresi ekledik
        this.success = true;
        this.message = message;
        this.code = httpStatus.value();     // HttpStatus.OK.value() yerine diğer responseları almak için değiştirdik
        this.data = data;
    }

    public ResponseWrapper(String message, HttpStatus httpStatus) {
        this.message = message;
        this.code = httpStatus.value();
        this.success = true;
    }
}