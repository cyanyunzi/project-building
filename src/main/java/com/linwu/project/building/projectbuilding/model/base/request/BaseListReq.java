package com.linwu.project.building.projectbuilding.model.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@ApiModel(description = "列表信息")
@Data
public class BaseListReq<T> extends BaseReq {
  @ApiModelProperty("列表")
  @Valid
  @NotNull(message = "请求列表参数不能为null")
  @Size(min = 1,message = "请求列表参数小于1")
  private List<T> records;
}
