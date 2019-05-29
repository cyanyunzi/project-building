package com.linwu.project.building.projectbuilding.exceptions;

import com.linwu.project.building.projectbuilding.enums.ResponseEmum;
import lombok.Getter;

@Getter
public class ParamsException extends RuntimeException{
    private String code;

    public ParamsException(String code, String message) {
        super(message);
        this.code = code;
    }

    public static ParamsException build(String code, String message) {
        return new ParamsException(code, message);
    }

    public static ParamsException build(String message) {
        return new ParamsException(ResponseEmum.PARAMS_ERROR.getCode(), message);
    }
}
