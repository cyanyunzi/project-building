package com.linwu.project.building.projectbuilding.model.base.response;

import com.linwu.project.building.projectbuilding.enums.ResponseEmum;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class Result<T extends BaseResp> implements Serializable {
  private String respCode;
  private String respDesc;
  private String bizCode;
  private T data;

  public static Result bizError(String message) {
    Result result = new Result();
    result.setRespCode(ResponseEmum.BIZ_ERROR.getCode());
    result.setRespDesc(message);
    return result;
  }

  public static Result paramsError(String message) {
    Result result = new Result();
    result.setRespCode(ResponseEmum.PARAMS_ERROR.getCode());
    result.setRespDesc(message);
    return result;
  }

  public static Result systemError(String message) {
    Result result = new Result();
    result.setRespCode(ResponseEmum.SYSTEM_ERROR.getCode());
    result.setRespDesc(message);
    return result;
  }

  public static Result success() {
    return success(null);
  }

  public static <T extends BaseResp> Result success(T data) {
    Result result = new Result();
    result.setData(data);
    return result;
  }
}
