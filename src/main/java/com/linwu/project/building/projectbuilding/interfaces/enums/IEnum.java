package com.linwu.project.building.projectbuilding.interfaces.enums;

import java.io.Serializable;

/**
 * @author ：ZhangLei
 * @date ：2018/8/13
 * @description : 针对枚举动态swagger展示枚举值扩展
 */
public interface IEnum<C extends Serializable, M extends Serializable> {
  C getCode();

  M getMsg();
}
