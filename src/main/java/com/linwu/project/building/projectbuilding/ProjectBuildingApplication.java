package com.linwu.project.building.projectbuilding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // 开启异步调用
public class ProjectBuildingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectBuildingApplication.class, args);
        System.err.println("sample started.  http://localhost:8080/swagger-ui.html");
    }

}
