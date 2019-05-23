package com.linwu.project.building.projectbuilding.utils;

import com.linwu.project.building.projectbuilding.exceptions.ParamsException;
import com.linwu.project.building.projectbuilding.model.base.request.BaseReq;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author ：林雾
 * @date ：2019/03/07
 * @description :
 */
public class ValidUtils {

    public static<T extends BaseReq> void validate(Validator validator, T var1, Class... var2){
        Set<ConstraintViolation<T>> validate = validator.validate(var1, var2);
        validate.stream().findFirst().ifPresent(error->{
            throw new ParamsException("1111",error.getMessage());
        });
    }
}
