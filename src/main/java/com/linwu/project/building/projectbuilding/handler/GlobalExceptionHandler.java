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
    log.error(
        "=================RestApi Error================= URL:{} METHOD:{} message:{}  Exception: {}",
        RequestUtils.getRequest().getRequestURL().toString(),
        RequestUtils.getRequest().getMethod(),
        ex.getMessage(),
        ex);

    Result systemError = Result.success();
    systemError.setRespCode("9999");
    systemError.setRespDesc(ex.getMessage());

    return systemError;
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

    Result paramsError = Result.success();
    paramsError.setRespCode("1111");
    paramsError.setRespDesc(message);
    return paramsError;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public Result validatedException(MethodArgumentNotValidException ex) {
    Optional<ObjectError> first = ex.getBindingResult().getAllErrors().stream().findFirst();
    String message = first.map(error -> error.getDefaultMessage()).orElse("参数校验异常");

    Result paramsError = Result.success();
    paramsError.setRespCode("1111");
    paramsError.setRespDesc(message);
    return paramsError;
  }

  @ExceptionHandler(BizException.class)
  @ResponseBody
  public Result bizException(BizException ex) {
    log.info(
        "=================BizException================= Url:{} message:{}",
        RequestUtils.getRequest().getRequestURL(),
        ex.getMessage());

    Result paramsError = Result.success();
    paramsError.setRespCode(ex.getCode());
    paramsError.setRespDesc(ex.getMessage());
    return paramsError;
  }
    
  @ExceptionHandler(ParamsException.class)
  @ResponseBody
  public Result paramsException(ParamsException ex) {
    log.info(
        "=================paramsException================= Url:{} message:{}",
        RequestUtils.getRequest().getRequestURL(),
        ex.getMessage());

    Result paramsError = Result.success();
    paramsError.setRespCode(ex.getCode());
    paramsError.setRespDesc(ex.getMessage());
    return paramsError;
  }
}
