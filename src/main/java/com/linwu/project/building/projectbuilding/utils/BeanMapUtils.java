package com.linwu.project.building.projectbuilding.utils;

import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：ZhangLei
 * @date ：2018/11/30
 * @description :
 */
public class BeanMapUtils {
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>(16);
        if (bean != null) {
            BeanMap tempMap = BeanMap.create(bean);
            for (Object key : tempMap.keySet()) {
                String putKey = String.valueOf(key);
                Object putValue = tempMap.get(key);
                map.put(putKey, putValue);
            }
        }
        return map;
    }

    public static <T> MultiValueMap<String, String> beanToMultiValueMap(T bean) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>(16);
        if (bean != null) {
            BeanMap tempMap = BeanMap.create(bean);
            for (Object key : tempMap.keySet()) {
                String putKey = String.valueOf(key);
                Object putValue = tempMap.get(key);
                if(putValue!=null){
                    if(putValue instanceof LocalDateTime){
                        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        map.add(putKey,  df.format((LocalDateTime) putValue));
                    }else{
                        map.add(putKey, putValue.toString());
                    }
                }
            }
        }
        return map;
    }
}
