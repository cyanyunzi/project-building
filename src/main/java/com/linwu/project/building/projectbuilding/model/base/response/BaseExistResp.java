package com.linwu.project.building.projectbuilding.model.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class BaseExistResp extends BaseResp {
    @ApiModelProperty("true 存在， false 不存在")
    private Boolean exist = false;
}
