package com.linwu.project.building.projectbuilding.utils;

import com.google.common.collect.Lists;
import com.linwu.project.building.projectbuilding.model.base.response.BaseListResp;
import com.linwu.project.building.projectbuilding.model.base.response.BasePageListResp;
import com.linwu.project.building.projectbuilding.model.base.response.BaseResp;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author ：ZhangLei
 * @date ：2018/11/29
 * @description :
 */
public class ConvertRespUtils {
    /**
     * Po转VO
     *
     * @param t
     * @param respClass
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R > R convertResp(T t, Class<R> respClass) {
        try {
            if (t == null) {
                return null;
            }
            R r = respClass.newInstance();
            BeanUtils.copyProperties(t, r);
            return r;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * PoList转VOList
     *
     * @param t
     * @param respClass
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R extends BaseResp> List<R> convertRespList(List<T> t, Class<R> respClass) {
        try {
            if (CollectionUtils.isEmpty(t)) {
                return Lists.newArrayList();
            }
            List<R> list = Lists.newArrayList();
            t.forEach(bean -> list.add(convertResp(bean, respClass)));
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * PoList转VOList
     *
     * @param t
     * @param respClass
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R extends BaseResp> BaseListResp<R> convertBaseListResp(
            List<T> t, Class<R> respClass) {
        try {
            BaseListResp baseListResp = new BaseListResp();
            if (!CollectionUtils.isEmpty(t)) {
                t.forEach(bean -> baseListResp.getRecords().add(convertResp(bean, respClass)));
            }
            return baseListResp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}