package com.linwu.project.building.projectbuilding.model.base.request;

import com.linwu.project.building.projectbuilding.model.base.BaseBean;
import com.linwu.project.building.projectbuilding.model.base.query.BaseQuery;
import com.linwu.project.building.projectbuilding.model.query.StudentQuery;
import com.linwu.project.building.projectbuilding.model.request.student.StudentReq;
import com.linwu.project.building.projectbuilding.utils.ConvertUtils;

/**
 * @author ：ZhangLei
 * @date ：2018/11/20
 * @description :请求基类
 */
public class BaseReq extends BaseBean {

  public <Q extends BaseQuery> Q convertQuery(Class<Q> clazz) {
    return ConvertUtils.convertResp(this,clazz);
  }

  public static void main(String[] args) {
    StudentQuery query = new StudentReq(1, 24, "张磊1").convertQuery(StudentQuery.class);
    System.out.println(query);
  }
}
