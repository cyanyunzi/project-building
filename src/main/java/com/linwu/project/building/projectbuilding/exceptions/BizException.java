package com.linwu.project.building.projectbuilding.exceptions;

import lombok.Getter;

@Getter
public class BizException extends RuntimeException{
    private String code;

    public BizException(String code,String message) {
        super(message);
        this.code = code;
    }

}
