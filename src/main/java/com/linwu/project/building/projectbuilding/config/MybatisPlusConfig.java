package com.linwu.project.building.projectbuilding.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.linwu.project.building.projectbuilding.plus.MySqlInjector;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：林雾
 * @date ：2019/05/29
 * @description :
 */
@Configuration
public class MybatisPlusConfig {
  /** 自定义扩展sql */
  @Bean
  public ISqlInjector sqlInjector() {
    return new MySqlInjector();
  }

  /** 乐观锁 */
  @Bean
  public OptimisticLockerInterceptor optimisticLockerInterceptor() {
    return new OptimisticLockerInterceptor();
  }

  /** 分页插件 */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
  }

  /** 性能分析插件 */
  @Bean
  public PerformanceInterceptor performanceInterceptor() {
    PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
    // 格式化sql语句
    performanceInterceptor.setFormat(true);
    return performanceInterceptor;
  }
}
