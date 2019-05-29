package com.linwu.project.building.projectbuilding.handler;

import com.linwu.project.building.projectbuilding.exceptions.BizException;
import com.linwu.project.building.projectbuilding.exceptions.ParamsException;
import com.linwu.project.building.projectbuilding.model.base.response.Result;
import com.linwu.project.building.projectbuilding.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
  /** 处理所有不可知的异常 */
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public Result exception(Exception ex) {
    return Result.systemError(ex.getMessage());
  }

  /**
   * 针对Valid 校验异常拦截
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(ConstraintViolationException.class)
  public Result handleApiConstraintViolationException(ConstraintViolationException ex) {
    Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
    String message =
        violations.stream().map(set -> set.getMessage()).collect(Collectors.joining(","));

    return Result.paramsError(message);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public Result validatedException(MethodArgumentNotValidException ex) {
    Optional<ObjectError> first = ex.getBindingResult().getAllErrors().stream().findFirst();
    String message = first.map(error -> error.getDefaultMessage()).orElse("参数校验异常");

    return Result.paramsError(message);
  }

  @ExceptionHandler(BizException.class)
  @ResponseBody
  public Result bizException(BizException ex) {
    return Result.bizError(ex.getMessage());
  }

  @ExceptionHandler(ParamsException.class)
  @ResponseBody
  public Result paramsException(ParamsException ex) {
    return Result.paramsError(ex.getMessage());
  }
}
