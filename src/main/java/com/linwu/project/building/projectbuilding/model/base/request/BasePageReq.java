package com.linwu.project.building.projectbuilding.model.base.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author ：ZhangLei
 * @date ：2018/11/20
 * @description :分页请求基类
 */
@Data
public class BasePageReq extends BaseReq {
  @ApiModelProperty(value = "当前页码,默认1", required = true)
  @NotNull(message = "当前页码不能为null")
  @Min(value = 0, message = "当前页码非法参数")
  protected long current = 1;

  @ApiModelProperty(value = "当前页数量,默认10", required = true)
  @NotNull(message = "当前页数量不能为null")
  @Min(value = 0, message = "当前页数量参数错误")
  protected long size = 10;
}