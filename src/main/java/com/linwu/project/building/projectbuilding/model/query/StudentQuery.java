
package com.linwu.project.building.projectbuilding.model.query;

import com.linwu.project.building.projectbuilding.model.base.entity.BaseEntity;
import com.linwu.project.building.projectbuilding.model.base.query.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhang.lei
 */
 
@Getter
@Setter
public class StudentQuery extends BaseQuery {
    private Integer age;
    private String name;

}
