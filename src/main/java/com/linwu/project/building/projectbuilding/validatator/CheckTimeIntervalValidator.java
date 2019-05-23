package com.linwu.project.building.projectbuilding.validatator;

import com.linwu.project.building.projectbuilding.annotations.CheckTimeInterval;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author ：林雾
 * @date ：2019/05/21
 * @description :
 * 校验 开始时间不能大于结束时间
 */
@Slf4j
public class CheckTimeIntervalValidator implements ConstraintValidator<CheckTimeInterval, Object> {
  private String startTime;
  private String endTime;

  @Override
  public void initialize(CheckTimeInterval checkTimeInterval) {
    this.startTime = checkTimeInterval.startTime();
    this.endTime = checkTimeInterval.endTime();
  }

  @Override
  public boolean isValid(
      Object obj /*请求对象req*/, ConstraintValidatorContext constraintValidatorContext) {
    if (startTime == null || endTime == null) {
      return true;
    }

    BeanWrapper beanWrapper = new BeanWrapperImpl(obj);

    Object start = beanWrapper.getPropertyValue(this.startTime);
    Object end = beanWrapper.getPropertyValue(this.endTime);

    if (start instanceof LocalDateTime && end instanceof LocalDateTime) {
      LocalDateTime p1 = (LocalDateTime) beanWrapper.getPropertyValue(this.startTime);
      LocalDateTime p2 = (LocalDateTime) beanWrapper.getPropertyValue(this.endTime);
      return p1.isBefore(p2) ? true : false;

    } else if (start instanceof LocalDate && end instanceof LocalDate) {
      LocalDate p1 = (LocalDate) beanWrapper.getPropertyValue(this.startTime);
      LocalDate p2 = (LocalDate) beanWrapper.getPropertyValue(this.endTime);
      return p1.isBefore(p2) ? true : false;

    } else if (start instanceof LocalTime && end instanceof LocalTime) {
      LocalTime p1 = (LocalTime) beanWrapper.getPropertyValue(this.startTime);
      LocalTime p2 = (LocalTime) beanWrapper.getPropertyValue(this.endTime);
      return p1.isBefore(p2) ? true : false;
    }
    throw new IllegalArgumentException("时间类型不一致");
  }
}
