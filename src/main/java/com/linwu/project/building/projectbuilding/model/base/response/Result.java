package com.linwu.project.building.projectbuilding.model.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class Result<T extends BaseResp> implements Serializable {
    private String respCode;
    private String respDesc;
    private String bizCode;
    private T data;

    public static Result success(){
        return success(null);
    }

    public static <T extends BaseResp> Result success(T data){
        Result result = new Result();
        result.setData(data);
        return result;
    }
}
