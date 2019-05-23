package com.linwu.project.building.projectbuilding.model.base.request;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author ：ZhangLei
 * @date ：2018/11/20
 * @description :请求基类
 */
public class BaseIdReq extends BaseReq  {
    @ApiModelProperty(value = "数据库主键ID,新增为NULL")
    protected Long id;

}
