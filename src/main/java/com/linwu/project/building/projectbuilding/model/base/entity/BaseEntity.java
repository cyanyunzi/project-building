package com.linwu.project.building.projectbuilding.model.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.linwu.project.building.projectbuilding.model.base.BaseBean;
import com.linwu.project.building.projectbuilding.model.base.response.BaseResp;
import com.linwu.project.building.projectbuilding.utils.ConvertUtils;
import lombok.Data;

/**
 * @author ：林雾
 * @date ：2019/05/24
 * @description :查询对象
 */
@Data
public class BaseEntity extends BaseBean {
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  public static final String ID = "id";

  public <R extends BaseResp> R convertResp(Class<R> clazz) {
    return ConvertUtils.convertResp(this, clazz);
  }
}
