package com.linwu.project.building.projectbuilding.model.base.response;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@ApiModel(description = "列表信息")
@Data
public class BaseListResp<T> extends BaseResp {
  @ApiModelProperty("列表")
  private List<T> records = Lists.newArrayList();

  public BaseListResp(){}

  public BaseListResp(List<T> records) {
    this.records = records;
  }
}
