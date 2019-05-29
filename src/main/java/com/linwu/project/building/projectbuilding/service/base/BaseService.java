package com.linwu.project.building.projectbuilding.service.base;

import com.google.common.collect.Lists;
import com.linwu.project.building.projectbuilding.model.base.entity.BaseEntity;
import com.linwu.project.building.projectbuilding.model.entity.Student;
import com.linwu.project.building.projectbuilding.utils.StreamUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @author ：林雾
 * @date ：2019/05/24
 * @description :
 */
@Service
public class BaseService {
  public <T extends BaseEntity, R> Set<?> mapperSet(List<T> list, Function<T, R> mapper) {
    return StreamUtils.mapperSet(list, mapper);
  }

  public <T extends BaseEntity, R> List<?> mapperList(List<T> list, Function<T, R> mapper) {
    return StreamUtils.mapperList(list, mapper);
  }

  public static void main(String[] args) {
    List<Student> list = Lists.newArrayList(new Student(1, "学1"), new Student(2, "学2"));

    BaseService baseService = new BaseService();
    Set<Integer> s1 = (Set<Integer>) baseService.mapperSet(list, bean -> bean.getAge());
    Set<String> s2 = (Set<String>) baseService.mapperSet(list, bean -> bean.getName());

    System.out.println(s1);
  }
}
