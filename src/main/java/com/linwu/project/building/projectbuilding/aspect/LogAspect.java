package com.linwu.project.building.projectbuilding.aspect;

import com.google.gson.Gson;
import com.linwu.project.building.projectbuilding.exceptions.BizException;
import com.linwu.project.building.projectbuilding.exceptions.ParamsException;
import com.linwu.project.building.projectbuilding.model.base.response.Result;
import com.linwu.project.building.projectbuilding.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：林雾
 * @date ：2019/05/29
 * @description :
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
  @Pointcut("execution(public * com.linwu.project.building.projectbuilding.controller.*.*.*(..))")
  public void webLog() {}

  @Before("webLog()")
  public void deBefore(JoinPoint joinPoint) {
    HttpServletRequest request = RequestUtils.getRequest();
    log.info(
        ">>>>>请求开始>>>>> URL:{} METHOD:{} args:{}",
        request.getRequestURL().toString(),
        request.getMethod(),
        new Gson().toJson(joinPoint.getArgs()));
  }

  @AfterReturning(returning = "ret", pointcut = "webLog()")
  public void doAfterReturning(JoinPoint jp, Object ret) throws Throwable {
    HttpServletRequest request = RequestUtils.getRequest();

    if (ret instanceof Result) {
      Result result = (Result) ret;
      log.info(
          "<<<<<请求结束<<<<<  URL: {} METHOD:{} result:{}",
          request.getRequestURL().toString(),
          request.getMethod(),
          new Gson().toJson(result));
    }
  }

  @AfterThrowing(pointcut = "webLog()", throwing = "e")
  public void throwss(JoinPoint jp, Throwable e) {
    HttpServletRequest request = RequestUtils.getRequest();
    String message = e.getMessage() == null ? "" : e.getMessage();
    if (e instanceof BizException || e instanceof ParamsException) {
      log.info("xxxxx校验错误xxxxx: url{} message:{}", request.getRequestURL(), message);
    } else {
      log.error(
          "*****Error***** URL:{} METHOD:{} args:{} Exception:{}",
          request.getRequestURL().toString(),
          request.getMethod(),
          new Gson().toJson(jp.getArgs()),
          e);
    }
  }
}
