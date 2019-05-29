package com.linwu.project.building.projectbuilding.model.request.student;

import com.linwu.project.building.projectbuilding.model.base.request.BaseReq;
import com.linwu.project.building.projectbuilding.model.request.valid.CreatOrUpdateReq;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author ：ZhangLei
 * @date ：2018/8/28
 * @description :
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentReq extends BaseReq {
    private Integer id;
    private Integer age;
    private String name;
}
