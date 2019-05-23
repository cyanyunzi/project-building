package com.linwu.project.building.projectbuilding.annotations;


import com.linwu.project.building.projectbuilding.validatator.CheckTimeIntervalValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author ：林雾
 * @date ：2019/05/21
 * @description :
 * 开始时间 小于 结束时间 校验
 */
@Target({TYPE_USE, METHOD, FIELD, ANNOTATION_TYPE})
//注解类的生命周期
@Retention(RUNTIME)
//指定校验具体的执行类
@Constraint(validatedBy = CheckTimeIntervalValidator.class)
public @interface CheckTimeInterval {
    String startTime();
    String endTime();
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
