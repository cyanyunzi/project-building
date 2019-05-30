package com.linwu.project.building.projectbuilding.model.response.user;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class UserResp extends BaseResp {

  @ApiModelProperty("userId")
  private Integer userId;

  @ApiModelProperty("userName")
  private String userName;

  @ApiModelProperty("isDel")
  private Integer isDel;

  @ApiModelProperty("deleteTime")
  @JsonFormat
  private LocalDateTime deleteTime;

  @ApiModelProperty("version")
  private Integer version;

  @ApiModelProperty("createdBy")
  private String createdBy;

  @ApiModelProperty("createdName")
  private String createdName;

  @ApiModelProperty("modifiedBy")
  private String modifiedBy;

  @ApiModelProperty("modifiedName")
  private String modifiedName;

  @ApiModelProperty("createdTime")
  @JsonFormat
  private LocalDateTime createdTime;

  @ApiModelProperty("modifiedTime")
  @JsonFormat
  private LocalDateTime modifiedTime;
}
