package com.linwu.project.building.projectbuilding.controller;

import com.linwu.project.building.projectbuilding.interfaces.validated.Create;
import com.linwu.project.building.projectbuilding.interfaces.validated.Update;
import com.linwu.project.building.projectbuilding.model.request.valid.CheckTimeIntervalReq;
import com.linwu.project.building.projectbuilding.model.request.valid.CreatOrUpdateReq;
import com.linwu.project.building.projectbuilding.model.request.valid.ValidAnnotationReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：ZhangLei
 * @date ：2018/7/30
 * @description :
 *
 * @Validated 注解 支持分组校验
 * @Valid 支持嵌套校验
 *
 */
@Api(tags = {"校验"})
@RestController
@RequestMapping("/valid")
@Slf4j
public class ValidController {

    @ApiOperation(value = "新建类型校验")
    @PostMapping("/create")
    public String validCreate(@Validated(Create.class) @RequestBody CreatOrUpdateReq req){
        log.info(req.toJson());
        return "SUCCESS";
    }

    @ApiOperation(value = "修改类型校验")
    @PutMapping("/update")
    public String validUpdate(@Validated(Update.class) @RequestBody CreatOrUpdateReq req){
        log.info(req.toJson());
        return "SUCCESS";
    }

    @ApiOperation(value = "嵌套类型校验")
    @PutMapping("/valid-annotation")
    public String validAnnotation(@Validated @RequestBody ValidAnnotationReq req){
        log.info(req.toJson());
        return "SUCCESS";
    }

    @ApiOperation(value = "自定义注解校验")
    @PutMapping("/CheckTimeInterval")
    public String checkTimeInterval(@Validated @RequestBody CheckTimeIntervalReq req){
        log.info(req.toJson());
        return "SUCCESS";
    }
}
