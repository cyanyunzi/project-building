package com.linwu.project.building.projectbuilding.enums;

import com.linwu.project.building.projectbuilding.interfaces.enums.IEnum;
import lombok.Data;
import lombok.Getter;

/**
 * @author ：林雾
 * @date ：2019/05/29
 * @description :
 */
@Getter
public enum ResponseEmum implements IEnum{
    SUCCESS("0000","成功"),
    SYSTEM_ERROR("9999","系统错误"),
    BIZ_ERROR("1111","业务错误"),
    PARAMS_ERROR("2222","参数校验错误"),
    ;

    private String code;
    private String msg;

    ResponseEmum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
