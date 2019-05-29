package com.linwu.project.building.projectbuilding.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.linwu.project.building.projectbuilding.model.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author 林雾
 * @since 2019-05-29
 */
@Data
public class User extends BaseEntity {

    private Integer userId;

    private String userName;

    private Integer isDel;

    /**
     * 逻辑删除时间
     */
    private LocalDateTime deleteTime;

    /**
     * 版本号
     */
    private Integer version;

    private String createdBy;

    private String createdName;

    private String modifiedBy;

    private String modifiedName;

    private LocalDateTime createdTime;

    private LocalDateTime modifiedTime;


    public static final String USER_ID = "user_id";

    public static final String USER_NAME = "user_name";

    public static final String IS_DEL = "is_del";

    public static final String DELETE_TIME = "delete_time";

    public static final String VERSION = "version";

    public static final String CREATED_BY = "created_by";

    public static final String CREATED_NAME = "created_name";

    public static final String MODIFIED_BY = "modified_by";

    public static final String MODIFIED_NAME = "modified_name";

    public static final String CREATED_TIME = "created_time";

    public static final String MODIFIED_TIME = "modified_time";
}
