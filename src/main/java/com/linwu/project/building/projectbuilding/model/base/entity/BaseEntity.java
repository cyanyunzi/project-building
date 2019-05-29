package com.linwu.project.building.projectbuilding.model.base.entity;

import com.linwu.project.building.projectbuilding.model.base.BaseBean;
import com.linwu.project.building.projectbuilding.model.base.response.BaseResp;
import com.linwu.project.building.projectbuilding.utils.ConvertUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * @author ：林雾
 * @date ：2019/05/24
 * @description :查询对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity extends BaseBean {
  private Integer id;

  public <R extends BaseResp> R convertResp(Class<R> clazz) {
      return ConvertUtils.convertResp(this,clazz);
  }
}
