package com.linwu.project.building.projectbuilding.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：林雾
 * @date ：2019/05/10
 * @description :
 */
public class RequestUtils {
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();
    }
}
