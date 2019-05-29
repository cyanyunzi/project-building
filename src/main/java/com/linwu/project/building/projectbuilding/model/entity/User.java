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

  /** 逻辑删除时间 */
  private LocalDateTime deleteTime;

  private String createdBy;

  private String createdName;

  private String modifiedBy;

  private String modifiedName;

  private LocalDateTime createdTime;

  private LocalDateTime modifiedTime;

  public static final String USER_ID = "user_id";

  public static final String USER_NAME = "user_name";

  public static final String DELETE_TIME = "delete_time";

  public static final String CREATED_BY = "created_by";

  public static final String CREATED_NAME = "created_name";

  public static final String MODIFIED_BY = "modified_by";

  public static final String MODIFIED_NAME = "modified_name";

  public static final String CREATED_TIME = "created_time";

  public static final String MODIFIED_TIME = "modified_time";
}
