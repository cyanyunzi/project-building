package com.linwu.project.building.projectbuilding.plus;

import static java.util.stream.Collectors.toList;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.Delete;
import com.baomidou.mybatisplus.core.injector.methods.DeleteBatchByIds;
import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.baomidou.mybatisplus.core.injector.methods.DeleteByMap;
import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.core.injector.methods.SelectBatchByIds;
import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.core.injector.methods.SelectByMap;
import com.baomidou.mybatisplus.core.injector.methods.SelectCount;
import com.baomidou.mybatisplus.core.injector.methods.SelectList;
import com.baomidou.mybatisplus.core.injector.methods.SelectMaps;
import com.baomidou.mybatisplus.core.injector.methods.SelectMapsPage;
import com.baomidou.mybatisplus.core.injector.methods.SelectObjs;
import com.baomidou.mybatisplus.core.injector.methods.SelectOne;
import com.baomidou.mybatisplus.core.injector.methods.SelectPage;
import com.baomidou.mybatisplus.core.injector.methods.Update;
import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ：林雾
 * @date ：2019/05/30
 * @description :
 */
public class MySqlInjector extends AbstractSqlInjector {

  @Override
  public List<AbstractMethod> getMethodList() {
    return Stream.of(
        new Insert(),
        new Delete(),
        new DeleteByMap(),
        new DeleteById(),
        new DeleteBatchByIds(),
        new Update(),
        new UpdateById(),
        new SelectById(),
        new SelectBatchByIds(),
        new SelectByMap(),
        new SelectOne(),
        new SelectCount(),
        new SelectMaps(),
        new SelectMapsPage(),
        new SelectObjs(),
        new SelectList(),
        new SelectPage(),
        new SelectByUserId()
    ).collect(toList());
  }
}
