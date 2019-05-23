package com.linwu.project.building.projectbuilding.exceptions;

import lombok.Getter;

@Getter
public class ParamsException extends RuntimeException{
    private String code;

    public ParamsException(String code, String message) {
        super(message);
        this.code = code;
    }

}
