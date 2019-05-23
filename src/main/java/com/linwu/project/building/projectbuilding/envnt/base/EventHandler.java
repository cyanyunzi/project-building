package com.linwu.project.building.projectbuilding.envnt.base;

import org.springframework.context.ApplicationEvent;

/**
 * @author ：林雾
 * @date ：2019/05/23
 * @description :
 */
public abstract class EventHandler extends ApplicationEvent {
    public EventHandler(Object source) {
        super(source);
    }

    public abstract void handler(Object source);
}
