package com.linwu.project.building.projectbuilding.exceptions;

import com.linwu.project.building.projectbuilding.enums.ResponseEmum;
import lombok.Getter;

@Getter
public class BizException extends RuntimeException {
  private String code;

  public BizException(String code, String message) {
    super(message);
    this.code = code;
  }

  public static BizException build(String code, String message) {
    return new BizException(code, message);
  }

  public static BizException build(String message) {
    return new BizException(ResponseEmum.BIZ_ERROR.getCode(), message);
  }
}
