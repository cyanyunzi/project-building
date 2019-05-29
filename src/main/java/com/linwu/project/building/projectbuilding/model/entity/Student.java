package com.linwu.project.building.projectbuilding.model.entity;

import com.linwu.project.building.projectbuilding.model.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：林雾
 * @date ：2019/05/29
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseEntity {
    private Integer age;
    private String name;
}
