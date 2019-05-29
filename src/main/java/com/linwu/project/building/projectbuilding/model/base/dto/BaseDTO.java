package com.linwu.project.building.projectbuilding.model.base.dto;

import com.linwu.project.building.projectbuilding.model.base.BaseBean;
import com.linwu.project.building.projectbuilding.model.base.response.BaseResp;
import com.linwu.project.building.projectbuilding.utils.ConvertUtils;

/**
 * @author ：林雾
 * @date ：2019/05/24
 * @description :
 */
public class BaseDTO extends BaseBean {

  public <R extends BaseResp> R convertResp(Class<R> clazz) {
    return ConvertUtils.convertResp(this, clazz);
  }

}
