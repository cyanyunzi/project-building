package com.linwu.project.building.projectbuilding.listener;

import com.linwu.project.building.projectbuilding.envnt.base.EventHandler;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * @author ：林雾
 * @date ：2019/05/23
 * @description :
 */
@Component
public class SpringEventListener<T extends EventHandler> implements ApplicationListener {

//  @Async  异步执行
  @Override
  public void onApplicationEvent(ApplicationEvent applicationEvent) {
    if(applicationEvent instanceof EventHandler){
      System.out.println("Listener 执行...start");
      EventHandler eventHandler = (EventHandler) applicationEvent;
      eventHandler.handler(applicationEvent.getSource());
      System.out.println("Listener 执行...end");
    }
  }
}
