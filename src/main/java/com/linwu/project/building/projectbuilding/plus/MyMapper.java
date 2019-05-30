package com.linwu.project.building.projectbuilding.plus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.io.Serializable;

/**
 * @author ：林雾
 * @date ：2019/05/30
 * @description :
 */
public interface MyMapper<T> extends BaseMapper<T> {
  T selectByUserId(Serializable userId);
}
