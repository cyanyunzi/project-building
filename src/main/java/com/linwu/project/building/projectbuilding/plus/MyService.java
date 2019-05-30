package com.linwu.project.building.projectbuilding.plus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.io.Serializable;

/**
 * @author ：林雾
 * @date ：2019/05/30
 * @description :
 */
public class MyService<M extends MyMapper<T>, T> extends ServiceImpl<M, T> {
  public T getByUserId(Serializable userId) {
    return this.baseMapper.selectByUserId(userId);
  }
}
