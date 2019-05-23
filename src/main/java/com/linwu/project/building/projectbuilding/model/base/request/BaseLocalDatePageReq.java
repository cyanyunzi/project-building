package com.linwu.project.building.projectbuilding.model.base.request;

import com.linwu.project.building.projectbuilding.annotations.CheckTimeInterval;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author ：ZhangLei
 * @date ：2018/11/20
 * @description :分页请求基类
 */
@Data
@CheckTimeInterval(startTime = "startTime", endTime = "endTime", message = "开始时间大于结束时间")
public class BaseLocalDatePageReq extends BasePageReq {
  @ApiModelProperty(value = "开始时间 yyyy-MM-dd", example = "yyyy-MM-dd")
  @DateTimeFormat
  private LocalDate startTime;

  @ApiModelProperty(value = "结束时间 yyyy-MM-dd", example = "yyyy-MM-dd")
  @DateTimeFormat
  private LocalDate endTime;
}