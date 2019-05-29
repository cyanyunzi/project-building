package com.linwu.project.building.projectbuilding.model.base.response;

import com.linwu.project.building.projectbuilding.model.base.request.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ：ZhangLei
 * @date ：2018/11/20
 * @description :响应携带ID基类
 */
@ApiModel
@Data
public class BaseIdResp extends BaseResp  {
    @ApiModelProperty(value = "数据库主键ID")
    private Integer id;
}
