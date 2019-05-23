package com.linwu.project.building.projectbuilding.envnt;

import com.linwu.project.building.projectbuilding.envnt.base.EventHandler;
import com.linwu.project.building.projectbuilding.service.EventService;

import java.util.Map;

/**
 * @author ：林雾
 * @date ：2019/05/23
 * @description :
 */
public class CustomSpringEvent extends EventHandler {
  private EventService eventService;

  public CustomSpringEvent(Object source,EventService eventService) {
    super(source);
    this.eventService = eventService;
  }

  @Override
  public void handler(Object source) {
    Map<String, Object> map = (Map<String, Object>) this.getSource();
    System.out.println("CustomSpringEvent handler 执行...start");
    System.out.println(map.toString());
    System.out.println("CustomSpringEvent handler 执行...end");

    eventService.testHttpService();
  }
}
