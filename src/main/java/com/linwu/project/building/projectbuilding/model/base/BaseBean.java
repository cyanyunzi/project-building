package com.linwu.project.building.projectbuilding.model.base;

import com.google.gson.Gson;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;

/**
 * @author ：林雾
 * @date ：2019/05/24
 * @description :
 */
@Data
public class BaseBean implements Serializable {
    public static final Gson GSON = new Gson();
    public String toJson() {
        return GSON.toJson(this);
    }
}
