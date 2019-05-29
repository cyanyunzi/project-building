package com.linwu.project.building.projectbuilding.model.request.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.linwu.project.building.projectbuilding.model.base.request.BaseReq;
import com.linwu.project.building.projectbuilding.model.base.response.BaseResp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/** @author zhang.lei */
@ApiModel
@Getter
@Setter
public class UserReq extends BaseReq {
  @ApiModelProperty("userId")
  private Integer userId;

  @ApiModelProperty("userName")
  private String userName;
}
