package com.linwu.project.building.projectbuilding.model.request.valid;

import com.linwu.project.building.projectbuilding.model.base.request.BaseReq;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author ：ZhangLei
 * @date ：2018/8/28
 * @description :
 */
@ApiModel
@Data
public class ValidAnnotationReq extends BaseReq {

    @NotNull(message = "嵌套对象")
    @Valid
    private CreatOrUpdateReq req;
}
