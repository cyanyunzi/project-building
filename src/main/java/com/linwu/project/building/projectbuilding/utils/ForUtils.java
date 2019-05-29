package com.linwu.project.building.projectbuilding.utils;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ：林雾
 * @date ：2019/05/28
 * @description :
 */
public class ForUtils {
  /**
   * @param list 循环list
   * @param consumer 具体执行的代码函数
   * @param <T>
   */
  public static <T> void forEach(List<T> list, Consumer<T> consumer) {
    list.forEach(t->consumer.accept(t));
  }
}
