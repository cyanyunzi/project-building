package com.linwu.project.building.projectbuilding.model.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(description = "分页列表")
@Data
public class BasePageListResp<T> extends BaseResp {
  @ApiModelProperty("总条数")
  private long total;

  @ApiModelProperty("当前页码")
  private long current;

  @ApiModelProperty("分页数量")
  private long size;

  @ApiModelProperty("分页列表")
  private List<T> records ;
}
