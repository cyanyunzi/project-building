package com.linwu.project.building.projectbuilding.model.request.valid;

import com.linwu.project.building.projectbuilding.interfaces.validated.Create;
import com.linwu.project.building.projectbuilding.interfaces.validated.Update;
import com.linwu.project.building.projectbuilding.model.base.request.BaseReq;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author ：ZhangLei
 * @date ：2018/8/28
 * @description :
 */
@ApiModel
@Data
public class CreatOrUpdateReq extends BaseReq {
    @NotNull(message = "缺少ID",groups = {Update.class})
    private Integer id;

    @NotEmpty(message = "缺少名称",groups = {Create.class})
    private String name;
}
