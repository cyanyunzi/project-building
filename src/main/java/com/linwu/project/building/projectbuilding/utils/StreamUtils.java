package com.linwu.project.building.projectbuilding.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：林雾
 * @date ：2019/05/28
 * @description :
 */
public class StreamUtils {
  public static <T, R> List<R> mapperList(List<T> list, Function<T, R> mapper) {
    return parallelStream(list).map(mapper).collect(Collectors.toList());
  }

  public static <T> List<T> mapperList(List<T> list, Predicate<T> predicate) {
    return parallelStream(list).filter(predicate).collect(Collectors.toList());
  }

  public static <T, R> Set<R> mapperSet(List<T> list, Function<T, R> mapper) {
    return parallelStream(list).map(mapper).collect(Collectors.toSet());
  }

  public static <T, R> Map<R, List<T>> mapperMap(List<T> list, Function<T, R> mapper) {
    return parallelStream(list).collect(Collectors.groupingBy(mapper));
  }

  public static <T> Stream<T> parallelStream(List<T> list) {
    return list.parallelStream();
  }
}
