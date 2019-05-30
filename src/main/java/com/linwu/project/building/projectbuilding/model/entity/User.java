package com.linwu.project.building.projectbuilding.model.entity;

import com.linwu.project.building.projectbuilding.model.base.entity.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户信息
 *
 * @author 林雾
 * @since 2019-05-29
 */
@Data
public class User extends BaseEntity {

  private Integer userId;

  private String userName;

  public static final String USER_ID = "user_id";

  public static final String USER_NAME = "user_name";


}
