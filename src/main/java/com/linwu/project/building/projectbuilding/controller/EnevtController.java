package com.linwu.project.building.projectbuilding.controller;

import com.google.common.collect.Maps;
import com.linwu.project.building.projectbuilding.envnt.CustomSpringEvent;
import com.linwu.project.building.projectbuilding.model.base.response.Result;
import com.linwu.project.building.projectbuilding.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ：ZhangLei
 * @date ：2018/7/30
 * @description :
 */
@Api(tags = {"事件"})
@RestController
@RequestMapping("/enevt")
@Slf4j
public class EnevtController {
  @Autowired private ApplicationEventPublisher applicationEventPublisher;
  @Autowired private EventService eventService;

  @ApiOperation(value = "事件")
  @GetMapping
  public Result enevt() {
    Map<String, Object> map = Maps.newHashMap();
    map.put("测试事件", new Object());
    applicationEventPublisher.publishEvent(new CustomSpringEvent(map, eventService));
    applicationEventPublisher.publishEvent(new CustomSpringEvent(map, eventService));
    applicationEventPublisher.publishEvent(new CustomSpringEvent(map, eventService));
    return Result.success();
  }
}
