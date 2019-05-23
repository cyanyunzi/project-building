package com.linwu.project.building.projectbuilding.model.base.response;

import com.linwu.project.building.projectbuilding.model.base.request.BaseReq;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ：ZhangLei
 * @date ：2018/11/20
 * @description :响应携带ID基类
 */
public class BaseIdResp extends BaseResp  {
    @ApiModelProperty(value = "数据库主键ID")
    protected Long id;

}
