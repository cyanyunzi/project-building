package com.linwu.project.building.projectbuilding.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.linwu.project.building.projectbuilding.model.base.UserContext;
import com.linwu.project.building.projectbuilding.utils.UserContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author ：林雾
 * @date ：2019/05/30
 * @description :
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    log.info("开始新增填充操作人字段 insert fill ....");
    UserContext userContext = UserContextHolder.getUserContext();

    if (userContext == null) {
      log.info("操作人userContext 为null  insert fill ....");
      return;
    }

    this.setInsertFieldValByName("createdBy", userContext.getUserId(), metaObject);
    this.setInsertFieldValByName("createdName", userContext.getUsername(), metaObject);
    log.info("结束新增填充操作人字段 insert fill ....");
  }

  @Override
  public void updateFill(MetaObject mtaObject) {
    log.info("开始自动填充操作人字段 update fill ....");
    UserContext userContext = UserContextHolder.getUserContext();

    if (userContext == null) {
      log.info("操作人userContext 为null  update fill ....");
      return;
    }

    this.setUpdateFieldValByName("modifiedBy", userContext.getUserId(), mtaObject);
    this.setUpdateFieldValByName("modifiedName", userContext.getUsername(), mtaObject);
    log.info("结束自动填充操作人字段 update fill ....");
  }
}
