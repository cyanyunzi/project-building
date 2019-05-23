package com.linwu.project.building.projectbuilding.utils;


import com.linwu.project.building.projectbuilding.interfaces.enums.IEnum;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author ：林雾
 * @date ：2019/05/21
 * @description :
 */
public class IEnumUtils {
  /**
   * @param c code
   * @param clazz 枚举类
   * @param <T> 枚举类
   * @param <C> 需要与CODE比对的参数
   * @return
   */
  public static <T extends IEnum, C extends Serializable> C getCode(C c, Class<T> clazz) {
    Objects.requireNonNull(clazz);
    Objects.requireNonNull(c);

    IEnum[] enums = getEnums(clazz);

    return (C)
        Arrays.stream(enums)
            .filter(iEnum -> iEnum.getCode().equals(c))
            .findFirst()
            .map(iEnum -> iEnum.getCode())
            .orElseThrow(() -> new IllegalArgumentException("未匹配到枚举code"));
  }

  /**
   * @param iEnum 枚举类
   * @param <C> code
   * @return
   */
  public static <C extends Serializable> C getCode(IEnum iEnum) {
    Objects.requireNonNull(iEnum);

    IEnum[] enums = getEnums(iEnum.getClass());

    return (C)
        Arrays.stream(enums)
            .filter(e -> e.equals(iEnum))
            .findFirst()
            .map(e -> e.getCode())
            .orElseThrow(() -> new IllegalArgumentException("未匹配到枚举code"));
  }

  /**
   * @param m msg
   * @param clazz 枚举类
   * @param <T>
   * @param <M>
   * @param <C>
   * @return
   */
  public static <T extends IEnum, M extends Serializable, C extends Serializable> C getCodeByMsg(
      M m, Class<T> clazz) {

    Objects.requireNonNull(clazz);
    Objects.requireNonNull(m);

    IEnum[] enums = getEnums(clazz);

    return (C)
        Arrays.stream(enums)
            .filter(e -> e.getMsg().equals(m))
            .findFirst()
            .map(e -> e.getCode())
            .orElseThrow(() -> new IllegalArgumentException("未匹配到枚举code"));
  }



  public static <T extends IEnum> IEnum[] getEnums(Class<T> clazz) {
    return clazz.getEnumConstants();
  }

}
