package com.linwu.project.building.projectbuilding.model.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.linwu.project.building.projectbuilding.model.base.BaseBean;
import com.linwu.project.building.projectbuilding.model.base.response.BaseResp;
import com.linwu.project.building.projectbuilding.utils.ConvertUtils;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author ：林雾
 * @date ：2019/05/24
 * @description :查询对象
 */
@Data
public class BaseEntity extends BaseBean {
  @TableId(value = "id", type = IdType.AUTO)
  protected Integer id;

  /** 版本号 */
  @Version protected Integer version;

  @TableLogic protected Integer isDel;

  /** 逻辑删除时间 */
  protected LocalDateTime deleteTime;

  @TableField(fill = FieldFill.INSERT)
  protected String createdBy;

  @TableField(fill = FieldFill.INSERT)
  protected String createdName;

  @TableField(fill = FieldFill.UPDATE)
  protected String modifiedBy;

  @TableField(fill = FieldFill.UPDATE)
  protected String modifiedName;

  protected LocalDateTime createdTime;

  protected LocalDateTime modifiedTime;

  public static final String ID = "id";

  public static final String IS_DEL = "is_del";

  public static final String VERSION = "version";

  public static final String DELETE_TIME = "delete_time";

  public static final String CREATED_BY = "created_by";

  public static final String CREATED_NAME = "created_name";

  public static final String MODIFIED_BY = "modified_by";

  public static final String MODIFIED_NAME = "modified_name";

  public static final String CREATED_TIME = "created_time";

  public static final String MODIFIED_TIME = "modified_time";

  public <R extends BaseResp> R convertResp(Class<R> clazz) {
    return ConvertUtils.convertResp(this, clazz);
  }
}
