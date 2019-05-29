package com.linwu.project.building.projectbuilding.model.request.user;

import com.linwu.project.building.projectbuilding.model.base.request.BaseLocalDateTimePageReq;
import com.linwu.project.building.projectbuilding.model.base.request.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/** @author zhang.lei */
@ApiModel
@Getter
@Setter
public class UserPageReq extends BaseLocalDateTimePageReq {
  @ApiModelProperty("userId")
  private Integer userId;

  @ApiModelProperty("userName")
  private String userName;
}
