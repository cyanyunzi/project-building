package com.linwu.project.building.projectbuilding.plus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ：林雾
 * @date ：2019/05/30
 * @description :
 */
@Getter
@AllArgsConstructor
public enum  MySqlMethod {
  SELECT_BY_USER_ID("selectByUserId", "根据用户ID查询查询一条数据", "SELECT %s FROM %s WHERE %s=#{%s} %s"),
  ;

  private final String method;
  private final String desc;
  private final String sql;
}
