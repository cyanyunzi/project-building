package com.linwu.project.building.projectbuilding.model.base.response;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * @author ：ZhangLei
 * @date ：2018/11/20
 * @description :响应类基类
 */
public class BaseResp implements Serializable {

  public static final Gson GSON = new Gson();

  public String toJson() {
    return GSON.toJson(this);
  }
}
