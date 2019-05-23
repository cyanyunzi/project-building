package com.linwu.project.building.projectbuilding.model.base.request;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author ：ZhangLei
 * @date ：2018/11/20
 * @description :请求基类
 */
public class BaseReq implements Serializable {
    public static final Gson GSON = new Gson();

    public String toJson() {
        return GSON.toJson(this);
    }
}
