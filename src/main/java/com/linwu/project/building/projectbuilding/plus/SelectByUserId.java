package com.linwu.project.building.projectbuilding.plus;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.defaults.RawSqlSource;

/**
 * @author ：林雾
 * @date ：2019/05/30
 * @description :
 */
public class SelectByUserId extends AbstractMethod {

  @Override
  public MappedStatement injectMappedStatement(
      Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
    MySqlMethod selectByUserId = MySqlMethod.SELECT_BY_USER_ID;

    List<TableFieldInfo> fieldList = tableInfo.getFieldList();
    Optional<TableFieldInfo> first = fieldList.parallelStream().filter(field -> "userId".equals(field.getProperty())).findFirst();

    //所有表公用的字段 使用自定义sql扩展
    String column = "user_id";
    String property= "userId";
    if (first.isPresent()) {
      column = first.get().getColumn();
      property = first.get().getProperty();
    }

    String sql = String.format(
        selectByUserId.getSql(),
        this.sqlSelectColumns(tableInfo, false),
        tableInfo.getTableName(),
        column,
        property,
        tableInfo.getLogicDeleteSql(true, false));

    SqlSource sqlSource =
        new RawSqlSource(
            this.configuration,
            sql,
            Object.class);
    return this.addSelectMappedStatement(
        mapperClass, selectByUserId.getMethod(), sqlSource, modelClass, tableInfo);
  }
}
