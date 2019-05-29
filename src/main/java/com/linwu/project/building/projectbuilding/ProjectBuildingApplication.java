package com.linwu.project.building.projectbuilding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication(
    scanBasePackages = "com.linwu.project.building.projectbuilding")
@EnableAsync // 开启异步调用
@MapperScan("com.linwu.project.building.projectbuilding.mapper")
public class ProjectBuildingApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProjectBuildingApplication.class, args);
    System.err.println("sample started.  http://localhost:8080/swagger-ui.html");
  }

  @Bean
  public RequestContextListener requestContextListener(){
    return new RequestContextListener();
  }
}
