package com.linwu.project.building.projectbuilding.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linwu.project.building.projectbuilding.model.base.response.BaseIdResp;
import com.linwu.project.building.projectbuilding.model.base.response.BaseListResp;
import com.linwu.project.building.projectbuilding.model.base.response.BasePageListResp;
import com.linwu.project.building.projectbuilding.model.base.response.Result;
import com.linwu.project.building.projectbuilding.model.entity.User;
import com.linwu.project.building.projectbuilding.model.entity.UserResp;
import com.linwu.project.building.projectbuilding.model.request.user.UserPageReq;
import com.linwu.project.building.projectbuilding.model.request.user.UserReq;
import com.linwu.project.building.projectbuilding.service.UserService;
import com.linwu.project.building.projectbuilding.utils.ConvertUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息 前端控制器
 *
 * @author 林雾
 * @since 2019-05-29
 */
@Api(tags = {"用户"})
@RestController
public class UserController {
  @Autowired private UserService userService;

  @ApiOperation(value = "用户分页列表")
  @GetMapping("/users")
  public Result<BasePageListResp<UserResp>> page(UserPageReq req) {
    QueryWrapper<User> wrapper = new QueryWrapper();
    if (null != req.getStartTime()) {
      wrapper.ge(User.CREATED_TIME, req.getStartTime());
    }
    if (null != req.getEndTime()) {
      wrapper.le(User.CREATED_TIME, req.getEndTime());
    }
    if (null != req.getUserId()) {
      wrapper.eq(User.USER_ID, req.getUserId());
    }
    if (null != req.getUserName()) {
      wrapper.like(User.USER_NAME, req.getUserName());
    }

    IPage<User> page = userService.page(new Page<>(req.getCurrent(), req.getSize()), wrapper);
    return Result.success(ConvertUtils.convertBasePageListResp(page, UserResp.class));
  }

  @ApiOperation(value = "用户数组列表")
  @GetMapping("/users/list")
  public Result<BaseListResp<UserResp>> list(UserPageReq req) {
    QueryWrapper<User> wrapper = new QueryWrapper();
    if (null != req.getStartTime()) {
      wrapper.ge(User.CREATED_TIME, req.getStartTime());
    }
    if (null != req.getEndTime()) {
      wrapper.le(User.CREATED_TIME, req.getEndTime());
    }
    if (null != req.getUserId()) {
      wrapper.eq(User.USER_ID, req.getUserId());
    }
    if (null != req.getUserName()) {
      wrapper.like(User.USER_NAME, req.getUserName());
    }
    wrapper.last(String.format("limit %s", req.getSize()));

    BaseListResp<UserResp> data =
        ConvertUtils.convertBaseListResp(userService.list(wrapper), UserResp.class);
    Result success = Result.success(data);
    return success;
  }

  @ApiOperation(value = "用户详情") //
  @GetMapping("/user/{id}")
  public Result<UserResp> detail(@PathVariable Integer id) {
    return Result.success(ConvertUtils.convertResp(userService.getById(id), UserResp.class));
  }

  @ApiOperation(value = "删除用户")
  @DeleteMapping("/user/{id}")
  public Result remove(@PathVariable Integer id) {
    userService.removeById(id);
    return Result.success();
  }

  @ApiOperation(value = "新增用户")
  @PostMapping("/user")
  public Result<BaseIdResp> add(@RequestBody UserReq req) {
    User user = req.convertEntity(User.class);
    userService.save(user);
    return Result.success(ConvertUtils.convertBaseIdResp(user));
  }

  @ApiOperation(value = "修改用户")
  @PutMapping("/user/{id}")
  public Result remove(@PathVariable Integer id, @RequestBody UserReq req) {
    Optional.ofNullable(userService.getById(id))
        .ifPresent(
            user -> {
              BeanUtils.copyProperties(req, user);
              userService.updateById(user);
            });

    return Result.success();
  }
}
